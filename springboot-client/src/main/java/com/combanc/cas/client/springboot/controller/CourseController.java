package com.combanc.cas.client.springboot.controller;

import com.combanc.cas.client.springboot.entity.CourseEntity;
import com.combanc.cas.client.springboot.entity.Result;
import com.combanc.cas.client.springboot.enums.ActionEnum;
import com.combanc.cas.client.springboot.enums.CourseSortFieldEnum;
import com.combanc.cas.client.springboot.enums.ResultCode;
import com.combanc.cas.client.springboot.enums.SortOrderEnum;
import com.combanc.cas.client.springboot.service.CourseService;
import com.combanc.cas.client.springboot.service.SignInService;
import com.combanc.cas.client.springboot.service.SignUpService;
import com.combanc.cas.client.springboot.service.UserService;
import com.combanc.cas.client.springboot.utils.ExcelExportUtil;
import com.combanc.cas.client.springboot.utils.PageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    private static Logger logger = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    private CourseService courseService;
    @Autowired
    private UserService userService;
    @Autowired
    private SignInService signInService;
    @Autowired
    private SignUpService signUpService;
    @ResponseBody
//    @IgnoreSecurity //忽略安全性检查
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Result create(CourseEntity courseEntity, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        if(courseEntity.getCourseStartDate().isEmpty()|| courseEntity.getCourseEndDate().isEmpty()||
                courseEntity.getCourseStartTime().isEmpty()|| courseEntity.getCourseEndTime().isEmpty()||courseEntity.getClassRoom().isEmpty()){
            return Result.failed("invalid argument");
        }
        courseEntity.setAction(ActionEnum.create.getCode());
        return courseService.save(courseEntity);

    }

    @ResponseBody
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public Result update(CourseEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        if (StringUtils.isEmpty(data.getId())) {
            return Result.build(ResultCode.PARAM_ERROR, "invalid argument");
        }
        data.setConcurSignUp(null);
        data.setAction(ActionEnum.update.getCode());
        return courseService.save(data);

    }
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public Result delete(@RequestParam(value = "id",required = true) String id, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        //userService.doCertification(request, ConstantUtils.USER_Researcher);
        try {
            CourseEntity data = new CourseEntity();
            data.setId(id);
            data.setAction(ActionEnum.update.getCode());
            data.setIsDelete(1);
            signInService.deleteByCourseId(id);
            signUpService.deleteByCourseId(id);
            return courseService.save(data);
        }catch (Exception e){
            logger.error(e.getMessage());
            return Result.failed();
        }

    }
    @ResponseBody
    @RequestMapping(value = "selectByPgList", method = RequestMethod.GET)
    public Result selectByPgList(CourseEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        // todo 暂时不考虑安全性，排序字段由api指定
//        if (!StringUtils.isEmpty(data.getSortField()) && !CourseSortFieldEnum.isValidValue(data.getSortField())) {
//            return Result.failed("invalid param sortField!");
//        }
        if (!StringUtils.isEmpty(data.getSortOrder()) && !SortOrderEnum.isValidValue(data.getSortOrder())) {
            return Result.failed("invalid param sortOrder!");
        }

        PageBean<CourseEntity> byList = courseService.findByPgList(data);
        return Result.success(byList);
    }

    @ResponseBody
    @RequestMapping(value = "selectByList", method = RequestMethod.GET)
    public Result selectByList(CourseEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
            return courseService.findByList(data);

    }
    @ResponseBody
    @RequestMapping(value = "selectById", method = RequestMethod.GET)
    public Result selectById(@RequestParam(value = "id",required = true) String id, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
            CourseEntity byId = courseService.findById(id);
            return Result.success(byId);

    }
    @ResponseBody
    @RequestMapping(value = "orderByCreateTime", method = RequestMethod.GET)
    public Result orderByCreateTime(CourseEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        return courseService.orderByCreateTime(data);

    }
    @ResponseBody
    @RequestMapping(value = "orderByTeacher", method = RequestMethod.GET)
    public Result orderByTeacher(CourseEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        return courseService.orderByTeacher(data);

    }

    @ResponseBody
    @RequestMapping(value = "orderByHot", method = RequestMethod.GET)
    public Result orderByHot(CourseEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        return courseService.orderByHot(data);

    }

    @ResponseBody
    @RequestMapping(value = "selectCourseByTimeAndClassRoom", method = RequestMethod.GET)
    public Result selectCourseByTimeAndClassRoom(CourseEntity data, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许
        if(data.getCourseStartDate().isEmpty()|| data.getCourseEndDate().isEmpty()||
        data.getCourseStartTime().isEmpty()|| data.getCourseEndTime().isEmpty()||data.getClassRoom().isEmpty()){
            return Result.failed("invalid argument");
        }
        return courseService.selectCourseByTimeAndClassRoom(data);

    }

    @ResponseBody
    @RequestMapping(value = "/excel/course2", method = RequestMethod.GET)
    public Result course2(CourseEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许

        try {
            List<Map> maps = new ArrayList<>();
            Result course = courseService.findByList(data);
            List<CourseEntity> list = (List<CourseEntity>) course.getResult();
            for (CourseEntity model : list) {
                Map map = new HashMap();
                map.put("courseTitle", model.getCourseTitle() == null ? "" : model.getCourseTitle());
                /*map.put("vodShowNum",model.getVodShowNum()==null?0:model.getVodShowNum());*/
                map.put("teacher", model.getTeacher() == null ? "" : model.getTeacher());
                map.put("courseStartDate", model.getCourseStartDate() == null ? "" : model.getCourseStartDate());
                map.put("courseEndDate", model.getCourseEndDate() == null ? "" : model.getCourseStartDate());
                map.put("courseStartTime", model.getCourseStartTime() == null ? "" : model.getCourseStartTime());
                map.put("courseEndTime", model.getCourseEndTime() == null ? "" : model.getCourseEndTime());
                map.put("lessonPeriod", model.getLessonPeriod() == null ? "" : model.getLessonPeriod());
                map.put("subject", model.getSubject() == null ? "" : model.getSubject());
                map.put("student", model.getStudent() == null ? "" : model.getStudent());
                map.put("recommend", model.getRecommend() == null ? "" : model.getRecommend());
                map.put("maxSignUp", model.getMaxSignUp() == null ? "" : model.getMaxSignUp());
                map.put("concurSignUp", model.getConcurSignUp() == null ? "" : model.getConcurSignUp());
                map.put("location", model.getLocation() == null ? "" : model.getLocation());
                maps.add(map);
            }

            String fileTitle = "tzjsyxw_course";
            String sheetTitle = "Sheet1";
            String[] title = new String[]{"课程名称", "主讲人", "活动开始日期", "活动结束日期",
                    "上课开始时间", "上课结束时间","学时","学段学科","参加对象","授课详情","最大报名人数","当前报名人数","授课地点"};        //设置表格表头字段
            String[] properties = new String[]{"courseTitle", "teacher", "courseStartDate", "courseEndDate",
                    "courseStartTime","courseEndTime","lessonPeriod","subject","student","recommend","maxSignUp","concurSignUp","location"};  // 查询对应的字段
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
    @RequestMapping(value = "/excel/course", method = RequestMethod.GET)
    public Result course(CourseEntity data, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "/https://sso.bjtzeduyun.com/");//设置跨域允许

        try {
            List<Map> maps = new ArrayList<>();
            Result course = courseService.findByList(data);
            List<CourseEntity> list = (List<CourseEntity>) course.getResult();
            for (CourseEntity model : list) {
                Map map = new HashMap();
                map.put("grade", model.getGrade() == null ? "" : model.getGrade());
                /*map.put("vodShowNum",model.getVodShowNum()==null?0:model.getVodShowNum());*/
                map.put("subject", model.getSubject() == null ? "" : model.getSubject());
                map.put("courseStartDate", model.getCourseStartDate() == null ? "" : model.getCourseStartDate());
                map.put("courseStartTime", model.getCourseStartTime() == null ? "" : model.getCourseStartTime());
                map.put("weeks", model.getWeeks() == null ? "" : model.getWeeks());
                map.put("location", model.getLocation() == null ? "" : model.getLocation());
                map.put("courseTitle", model.getCourseTitle() == null ? "" : model.getCourseTitle());
                map.put("teacher", model.getTeacher() == null ? "" : model.getTeacher());
                map.put("student", model.getStudent() == null ? "" : model.getStudent());
                map.put("recommend", model.getRecommend() == null ? "" : model.getRecommend());
                maps.add(map);
            }

            String fileTitle = "tzjsyxw_course";
            String sheetTitle = "Sheet1";
            String[] title = new String[]{"学段年级","学科","日期","上午\n下午","星期","活动方式\n活动地点","活动内容","主讲人","参加人","备注"};        //设置表格表头字段
            String[] properties = new String[]{"grade", "subject", "courseStartDate", "courseStartTime",
                    "weeks","location","courseTitle","teacher","student","recommend"};  // 查询对应的字段
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
