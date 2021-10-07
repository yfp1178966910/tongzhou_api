package com.combanc.cas.client.springboot.controller;

import com.combanc.cas.client.springboot.entity.SignUpEntity;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.enums.ResultCode;
import com.combanc.cas.client.springboot.service.SignUpService;
import com.combanc.cas.client.springboot.service.UserService;
import com.combanc.cas.client.springboot.utils.ConstantUtils;
import com.combanc.cas.client.springboot.utils.ExcelExportUtil;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;
    @Autowired
    private UserService userService;


    @ResponseBody
//    @IgnoreSecurity //忽略安全性检查
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result create(SignUpEntity SignUpEntity, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        SignUpEntity.setAction( ActionEnum.create.getCode());
        return signUpService.save(SignUpEntity);

    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(SignUpEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        if (StringUtils.isEmpty(data.getId())) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }
        data.setAction(ActionEnum.update.getCode());
        return signUpService.save(data);

    }
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Result delete(@RequestParam(value = "id",required = true) String id, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        SignUpEntity data = new SignUpEntity();
        data.setId(id);
        data.setAction(ActionEnum.delete.getCode());
        return signUpService.save(data);

    }
    @ResponseBody
    @RequestMapping(value = "selectByPgList", method = RequestMethod.GET)
    public Result selectByPgList(SignUpEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
            PageBean<SignUpEntity> byList = signUpService.findByPgList(data);
            return Result.success(byList);


    }
    @ResponseBody
    @RequestMapping(value = "selectByList", method = RequestMethod.GET)
    public Result selectByList(SignUpEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许
            return signUpService.findByList(data);

    }
    @ResponseBody
    @RequestMapping(value = "selectScoreByAdmin", method = RequestMethod.GET)
    public Result selectScoreByAdmin(SignUpEntity dto,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/");//设置跨域允许
        PageBean<Map<String, Object>> byList = signUpService.selectScoreByAdmin(dto);
            return Result.success(byList);

    }
    @ResponseBody
    @RequestMapping(value = "selectSuggestionByAdmin", method = RequestMethod.GET)
    public Result selectSuggestionByAdmin(SignUpEntity dto,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/");//设置跨域允许
        PageBean<Map<String, Object>> byList = signUpService.selectScoreByAdmin(dto);
        return Result.success(byList);

    }
    @ResponseBody
    @RequestMapping(value = "selectGetSumByYearByUser", method = RequestMethod.GET)
    public Result selectGetSumByYearByUser(SignUpEntity dto,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/");//设置跨域允许
        if (StringUtils.isEmpty(dto.getYear()) || StringUtils.isEmpty(dto.getUserId())){
            return Result.failed("缺少参数：年份或者用户Id");
        }
        PageBean<Map<String, Object>> byList = signUpService.selectGetSumByYearByUser(dto);
        return Result.success(byList);

    }
    @ResponseBody
    @RequestMapping(value = "selectCourseByYearAndUser", method = RequestMethod.GET)
    public Result selectCourseByYearAndUser(SignUpEntity dto,HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/");//设置跨域允许
        if (StringUtils.isEmpty(dto.getYear()) || StringUtils.isEmpty(dto.getUserId())){
            return Result.failed("缺少参数：年份或者用户Id");
        }
        List<Map<String, Object>> byList = signUpService.selectCourseByYearAndUser(dto);
        return Result.success(byList);

    }
    @ResponseBody
    @RequestMapping(value = "/excel/score", method = RequestMethod.GET)
    public Result score(SignUpEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许

        try {
            List<Map> maps = new ArrayList<>();
            PageBean<Map<String, Object>> signUp = signUpService.selectScoreByAdmin(data);
            List<Map<String, Object>> list =  signUp.getRows();
            for (Map model : list) {
                Map map = new HashMap();
                map.put("courseId", model.get("courseId") == null ? "" : model.get("courseId"));
                map.put("signUpType0", model.get("signUpType0") == null ? "" : Integer.valueOf(String.valueOf(model.get("signUpType0"))));
                map.put("signUpType1", model.get("signUpType1") == null ? "" : Integer.valueOf(String.valueOf(model.get("signUpType1"))));
                map.put("scoreA", model.get("scoreA") == null ? "" : Integer.valueOf(String.valueOf(model.get("scoreA"))));
                map.put("scoreB", model.get("scoreB") == null ? "" : Integer.valueOf(String.valueOf(model.get("scoreB"))));
                map.put("scoreC", model.get("scoreC") == null ? "" : Integer.valueOf(String.valueOf(model.get("scoreC"))));
                map.put("scoreD", model.get("scoreD") == null ? "" : Integer.valueOf(String.valueOf(model.get("scoreD"))));
                map.put("scoreE", model.get("scoreE") == null ? "": Integer.valueOf(String.valueOf(model.get("scoreE"))));
                map.put("scoreSum", model.get("score_sum") == null ? "" : Integer.valueOf(String.valueOf(model.get("score_sum"))));
                map.put("courseStartDate", model.get("courseStartDate") == null ? "" : model.get("courseStartDate"));
                map.put("courseEndDate", model.get("courseEndDate") == null ? "" : model.get("courseEndDate"));
                map.put("courseStartTime", model.get("courseStartTime") == null ? "" : model.get("courseStartTime"));
                map.put("courseEndTime", model.get("courseEndTime") == null ? "" : model.get("courseEndTime"));
                map.put("courseTitle", model.get("courseTitle") == null ? "" : model.get("courseTitle"));
                map.put("concurSignUp", model.get("concurSignUp") == null ? "" : Integer.valueOf(String.valueOf(model.get("concurSignUp"))));
                map.put("location", model.get("location") == null ? "" : model.get("location"));
                map.put("teacher", model.get("teacher") == null ? "" : model.get("teacher"));
                map.put("recommend", model.get("recommend") == null ? "" : model.get("recommend"));
                map.put("lesson_period", model.get("lesson_period") == null ? "" :new BigDecimal((String) model.get("lesson_period")));
                /*map.put("vodShowNum",model.getVodShowNum()==null?0:model.getVodShowNum());*/
                maps.add(map);
            }

            String fileTitle = "tzjsyxw_Score";
            String sheetTitle = "Sheet1";
            String[] title = new String[]{"课程Id","课程名称", "开始日期", "结束日期","上课时间","下课时间",
                    "研修员独立组织活动(人数)","外聘专家开展活动(人数)","活动内容具体有效","活动组织严密有序","活动过程调动参与","活动效果明显突出","活动源于基层需求"
                    ,"总分","参与人数","位置","主讲人","授课详情","课时"};        //设置表格表头字段
            String[] properties = new String[]{"courseId","courseTitle", "courseStartDate", "courseEndDate","courseStartTime","courseEndTime",
                    "signUpType0","signUpType1","scoreA", "scoreB","scoreC","scoreD", "scoreE","scoreSum", "concurSignUp", "location","teacher","recommend",
                    "lesson_period"};  // 查询对应的字段
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
    @RequestMapping(value = "/excel/signUp", method = RequestMethod.GET)
    public Result signUp(SignUpEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许

        try {
            List<Map> maps = new ArrayList<>();
            Result signUp = signUpService.findByList(data);
            List<SignUpEntity> list = (List<SignUpEntity>) signUp.getResult();
            for (SignUpEntity model : list) {
                Map map = new HashMap();
                map.put("userId", model.getUserId() == null ? "" : model.getUserId());
                map.put("trueName", model.getTrueName() == null ? "" : model.getTrueName());
                /*map.put("vodShowNum",model.getVodShowNum()==null?0:model.getVodShowNum());*/
                map.put("schoolName", model.getSchoolName() == null ? "" : model.getSchoolName());
                if(model.getUserType() != null ){
                    if(ConstantUtils.USER_TEACHER.toString().equals(model.getUserType())){map.put("userType","教师" );}
                    if(ConstantUtils.USER_RESEARCHER.toString().equals(model.getUserType())){map.put("userType","研修员" );}
                    if(ConstantUtils.USER_DIRECTOR.toString().equals(model.getUserType())){map.put("userType","部室主任" );}
                    if(ConstantUtils.USER_DEAN.toString().equals(model.getUserType())){map.put("userType","主管院长" );}
                    if(ConstantUtils.USER_HEAD.toString().equals(model.getUserType())){map.put("userType","教务负责人" );}
                }else {
                    map.put("userType","" );
                }


                maps.add(map);
            }

            String fileTitle = "tzjsyxw_SignUp";
            String sheetTitle = "Sheet1";
            String[] title = new String[]{"id","姓名", "学院", "用户类型"};        //设置表格表头字段
            String[] properties = new String[]{"userId","trueName", "schoolName", "userType"};  // 查询对应的字段
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
    @RequestMapping(value = "/excel/getScore", method = RequestMethod.GET)
    public Result getScore(SignUpEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");//设置跨域允许

        try {
            List<Map> maps = new ArrayList<>();
            data.setLimit(1);
            PageBean<Map<String, Object>> mapPageBean = signUpService.selectGetSumByYearByUser(data);
            data.setOffset(0);
            data.setLimit(mapPageBean.getTotal());
            PageBean<Map<String, Object>> signUp = signUpService.selectGetSumByYearByUser(data);
            List<Map<String, Object>> list = signUp.getRows();
            maps.addAll(list);
            //u.`true_name`,u.`school_name`,u.`subject`,u.`grade`,u.`phone`,u.`id`,g.getSum
            String fileTitle = "tzjsyxw_getScore"+'_'+data.getYear();
            String sheetTitle = "Sheet1";
            String[] title = new String[]{"姓名", "手机号", "教师ID","所属学校","学段","学科","学分"};        //设置表格表头字段
            String[] properties = new String[]{"trueName","phone", "id", "schoolName","grade","subject","getSum"};  // 查询对应的字段
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
