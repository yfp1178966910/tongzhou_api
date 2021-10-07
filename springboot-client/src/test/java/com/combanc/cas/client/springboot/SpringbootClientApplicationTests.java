package com.combanc.cas.client.springboot;

import com.combanc.cas.client.springboot.entity.CourseEntity;
import com.combanc.cas.client.springboot.enums.CourseSortFieldEnum;
import com.combanc.cas.client.springboot.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootClientApplicationTests {

	@Resource
	private CourseService courseService;

	@Test
	public void contextLoads() {
		CourseEntity courseEntity = new CourseEntity();
		courseEntity.setSortField("CONCUR_SIGN_UP");
		courseService.findByPgList(courseEntity);
	}

}
