package com.combanc.cas.client.springboot.controller;

import com.combanc.cas.client.springboot.entity.CourseEntity;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.entity.SignInEntity;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.service.CourseService;
import com.combanc.cas.client.springboot.service.SignInService;
import com.combanc.cas.client.springboot.service.UserService;
import com.combanc.cas.client.springboot.utils.Commons;
import com.combanc.cas.client.springboot.utils.ConstantUtils;
import com.combanc.cas.client.springboot.utils.ExcelExportUtil;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(path = {"/signIn", "/applets/signIn"})
public class SignInController {

    @Autowired
    private SignInService signInService;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

//    @ResponseBody
////    @IgnoreSecurity //忽略安全性检查
//    @RequestMapping(value = "create", method = RequestMethod.POST)
//    public Result create(SignInEntity SignInEntity, HttpServletRequest request, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
//        //userService.doCertification(request, ConstantUtils.USER_Researcher);
//        SignInEntity.setAction( ActionEnum.create.getCode());
//        return SignUpService.save(SignInEntity);
//
//    }


    //打卡
    @ResponseBody
    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public Result update(@RequestParam(value = "signUpId", required = true) String signUpId, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        //
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantUtils.DATE_FORMAT);

        SignInEntity signInEntity = new SignInEntity();
        signInEntity.setSignUpId(signUpId);
        signInEntity.setDate(dateFormat.format(now));
        List<SignInEntity> list = (List<SignInEntity>) signInService.findByList(signInEntity).getResult();
        if (list.size() != 1) {
            return Result.failed("当前日期下不存在该条签到信息");
        }
        SignInEntity data = list.get(0);
        //判断情况
        CourseEntity courseEntity = courseService.findById(data.getCourseId());
        String startTime = data.getDate() + " " + courseEntity.getCourseStartTime();
        String endTime = data.getDate() + " " + courseEntity.getCourseEndTime();

        SimpleDateFormat sdf = new SimpleDateFormat(ConstantUtils.DATETIME_FORMAT);
        SimpleDateFormat timeFormat = new SimpleDateFormat(ConstantUtils.TIME_FORMAT);

        //生成返回Map
        Map<String,String> result = new LinkedHashMap<>();
        try {

            long startTimeDate = sdf.parse(startTime).getTime();
            long beforeStartTimeDate = startTimeDate - ConstantUtils.ONE_HOUR_LONG;
            long lateTimeDate = startTimeDate + ConstantUtils.HALF_ONE_HOUR_LONG;//迟到提前半小时
            long endTimeDate = sdf.parse(endTime).getTime();
            long afterEndTimeDate = endTimeDate + ConstantUtils.ONE_HOUR_LONG;
            long signUp = now.getTime();
            String nowTime = timeFormat.format(now);
            //正常签到
            if (signUp > beforeStartTimeDate && signUp < startTimeDate) {
                data.setInTime(nowTime);
                data.setInStates(ConstantUtils.IN_STATES_NORMAL);
                putResult(result,"正常签到", nowTime);
            } else if (signUp > startTimeDate && signUp < lateTimeDate) {
                //迟到
                data.setInTime(nowTime);
                data.setInStates(ConstantUtils.IN_STATES_LATE);
                putResult(result,"迟到", nowTime);
            } else if (signUp > lateTimeDate && signUp < endTimeDate) {
                //早退
                data.setOutTime(nowTime);
                data.setOutStates(ConstantUtils.OUT_STATES_EARLY);
                putResult(result,"早退", nowTime);
            } else if (signUp > endTimeDate && signUp < afterEndTimeDate) {
                //正常签退
                data.setOutTime(nowTime);
                data.setOutStates(ConstantUtils.OUT_STATES_NORMAL);
                putResult(result,"正常签退", nowTime);
            } else {
                //无法打卡
                return Result.failed("当前时间无法打卡");
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
        data.setAction(ActionEnum.update.getCode());
        signInService.save(data);
        return Result.success(result);

    }

    private void putResult(Map<String, String> result,String states, String nowTime) {
        result.put("states",states);
        result.put("time",nowTime);
    }

    //申请补签
    @ResponseBody
    @RequestMapping(value = "checking", method = RequestMethod.POST)
    public Result checking(@RequestParam(value = "signInId", required = true) String signUpId,
                           @RequestParam(value = "inOrOut", required = true) String inOrOut,//0 签到  1 签退
                           @RequestParam(value = "remark", required = true) String remark,
                           HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        SignInEntity signInEntity = signInService.findById(signUpId);
        if("0".equals(inOrOut)){
            signInEntity.setInCheckStates(ConstantUtils.STATES_CHECKING);
            signInEntity.setInRemark(remark);
        }else if ("1".equals(inOrOut)){
            signInEntity.setOutCheckStates(ConstantUtils.STATES_CHECKING);
            signInEntity.setOutRemark(remark);
        }else {
            return Result.failed("错误的签到签退标识");
        }
        signInEntity.setAction(ActionEnum.update.getCode());
        return signInService.save(signInEntity);
    }

    //补签审核通过
    @ResponseBody
    @RequestMapping(value = "checked", method = RequestMethod.POST)
    public Result checked(@RequestParam(value = "signInId", required = true) String signUpId,
                          @RequestParam(value = "inOrOut", required = true) String inOrOut,//0 签到  1 签退
                          @RequestParam(value = "isSuccess", required = true) String isSuccess,//0 不通过  1 通过
                          HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许

        SignInEntity signInEntity = signInService.findById(signUpId);
        CourseEntity byId = courseService.findById(signInEntity.getCourseId());
        //如果课程结课状态，则无法补签通过
        if(ConstantUtils.COURSE_STATES_2.equals(byId.getCourseStates())&& "1".equals(isSuccess)){
            return Result.failed("课程目前为结课状态，无法补签通过");
        }
        if("0".equals(inOrOut) && "0".equals(isSuccess)){
            signInEntity.setInCheckStates(ConstantUtils.STATES_UNCHECKED);
        }else if("0".equals(inOrOut) && "1".equals(isSuccess)){
            signInEntity.setInCheckStates(ConstantUtils.STATES_CHECKED);
            signInEntity.setInStates(ConstantUtils.IN_STATES_NORMAL);
        }else if ("1".equals(inOrOut)&& "0".equals(isSuccess)){
            signInEntity.setOutCheckStates(ConstantUtils.STATES_UNCHECKED);
        }else if("1".equals(inOrOut)&& "1".equals(isSuccess)){
            signInEntity.setOutCheckStates(ConstantUtils.STATES_CHECKED);
            signInEntity.setOutStates(ConstantUtils.OUT_STATES_NORMAL);
        }else {
            return Result.failed("错误的签到签退标识");
        }
        signInEntity.setAction(ActionEnum.update.getCode());
        return signInService.save(signInEntity);
    }

    //    @ResponseBody
//    @RequestMapping(value = "delete", method = RequestMethod.POST)
//    public Result delete(@RequestParam(value = "id",required = true) String id, HttpServletRequest request, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
//        //userService.doCertification(request, ConstantUtils.USER_Researcher);
//        SignInEntity data = new SignInEntity();
//        data.setId(id);
//        data.setAction(ActionEnum.update.getCode());
//        data.setIsDelete(1);
//        return SignUpService.save(data);
//
//    }

    @ResponseBody
    @RequestMapping(value = "selectByPgList", method = RequestMethod.GET)
    public Result selectByPgList(SignInEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        if(!Commons.passCheck(data.getSignUpId(),data.getSecretKey())){
            return Result.failed("请求安全校验无法通过");
        }

        PageBean<SignInEntity> byList = signInService.findByPgList(data);
        return Result.success(byList);

    }


    //获取某种条件下统计信息
    @ResponseBody
    @RequestMapping(value = "findStatisticalData", method = RequestMethod.GET)
    public Result findStatisticalData(SignInEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        PageBean<Map<String ,String>> byList = signInService.findStatisticalData(data);
        return Result.success(byList);

    }

    //补签审核页面
    @ResponseBody
    @RequestMapping(value = "findCheckData", method = RequestMethod.GET)
    public Result findCheckData(SignInEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        PageBean<SignInEntity> byList = signInService.findCheckData(data);
        return Result.success(byList);

    }

    //查看某人谋课的详细打卡数据
    @ResponseBody
    @RequestMapping(value = "selectByList", method = RequestMethod.GET)
    public Result selectByList(SignInEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        return signInService.findByList(data);

    }
//    @ResponseBody
//    @RequestMapping(value = "selectScoreByAdmin", method = RequestMethod.GET)
//    public Result selectScoreByAdmin(SignInEntity dto,HttpServletRequest request, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
//        PageBean<Map<String, Object>> byList = SignUpService.selectScoreByAdmin(dto);
//            return Result.success(byList);
//
//    }

    @ResponseBody
    @RequestMapping(value = "/excel/course", method = RequestMethod.GET)
    public Result course(CourseEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许

        try {
            List<Map> maps = new ArrayList<>();
            Result course = courseService.findByList(data);
            List<CourseEntity> list = (List<CourseEntity>) course.getResult();
            for (CourseEntity model : list) {
                Map map = new HashMap();
                map.put("courseTitle", model.getCourseTitle() == null ? "" : model.getCourseTitle());
                /*map.put("vodShowNum",model.getVodShowNum()==null?0:model.getVodShowNum());*/
                map.put("courseStartTime", model.getCourseStartTime() == null ? "" : model.getCourseStartTime());
                map.put("courseEndTime", model.getCourseEndTime() == null ? "" : model.getCourseEndTime());
                map.put("concurSignUp", model.getConcurSignUp() == null ? "" : model.getConcurSignUp());
                map.put("location", model.getLocation() == null ? "" : model.getLocation());
                maps.add(map);
            }

            String fileTitle = "tzjsyxw_course";
            String sheetTitle = "Sheet1";
            String[] title = new String[]{"课程名称","上课开始时间", "上课结束时间","参与人数(人)","授课地点"};        //设置表格表头字段
            String[] properties = new String[]{"courseTitle","courseStartTime","courseEndTime","concurSignUp","location"};  // 查询对应的字段
            ExcelExportUtil excelExport2 = new ExcelExportUtil();
            excelExport2.setHeardList(title);//表头
            excelExport2.setHeardKey(properties);//属性KEY
            excelExport2.setData(maps);//数据
            excelExport2.setFontSize(11);
            excelExport2.setTitle(fileTitle);
            excelExport2.setSheetName(sheetTitle);
            excelExport2.exportExport(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();
    }

    @ResponseBody
    @RequestMapping(value = "/excel/signIn", method = RequestMethod.GET)
    public Result SignUp(SignInEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许

        try {
            List<Map> maps = new ArrayList<>();
            List<Map<String, String>> list = signInService.findStatisticalDataForExcel(data);

            for (Map model : list) {
                Map map = new HashMap();
                map.put("true_name", model.get("trueName") == null ? "" : model.get("trueName"));
                /*map.put("vodShowNum",model.getVodShowNum()==null?0:model.getVodShowNum());*/
                map.put("OUT_STATES_NORMAL", model.get("OUT_STATES_NORMAL") == null ? "" : model.get("OUT_STATES_NORMAL"));
                map.put("OUT_STATES_UNDO", model.get("OUT_STATES_UNDO") == null ? "" : model.get("OUT_STATES_UNDO"));
                map.put("OUT_STATES_EARLY", model.get("OUT_STATES_EARLY") == null ? "" : model.get("OUT_STATES_EARLY"));
                map.put("IN_STATES_NORMAL", model.get("IN_STATES_NORMAL") == null ? "" : model.get("IN_STATES_NORMAL"));
                map.put("IN_STATES_UNDO", model.get("IN_STATES_UNDO") == null ? "" : model.get("IN_STATES_UNDO"));
                map.put("IN_STATES_LATE", model.get("IN_STATES_LATE") == null ? "" : model.get("IN_STATES_LATE"));

                maps.add(map);
            }

            String fileTitle = "tzjsyxw_SignIn";
            String sheetTitle = "Sheet1";
            String[] title = new String[]{"姓名","正常签到数", "未签到数", "迟到数", "正常签退数", "未签退数", "早退数"};        //设置表格表头字段
            String[] properties = new String[]{"true_name", "IN_STATES_NORMAL", "IN_STATES_UNDO", "IN_STATES_LATE",
                    "OUT_STATES_NORMAL", "OUT_STATES_UNDO", "OUT_STATES_EARLY"};  // 查询对应的字段
            ExcelExportUtil excelExport2 = new ExcelExportUtil();
            excelExport2.setHeardList(title);//表头
            excelExport2.setHeardKey(properties);//属性KEY
            excelExport2.setData(maps);//数据
            excelExport2.setFontSize(11);
            excelExport2.setTitle(fileTitle);
            excelExport2.setSheetName(sheetTitle);
            excelExport2.exportExport(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success();
    }

}
