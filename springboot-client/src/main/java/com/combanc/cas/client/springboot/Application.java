package com.combanc.cas.client.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * springboot 启动类
 *
 * @author combanc_secondTeam
 */
@EnableTransactionManagement //开启事务的注解  使用@Transactional(readOnly = false,rollbackFor = Exception.class)
@SpringBootApplication
@MapperScan("com.combanc.cas.client.springboot.dao")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
