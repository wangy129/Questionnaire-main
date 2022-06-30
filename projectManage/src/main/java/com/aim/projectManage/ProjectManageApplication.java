package com.aim.projectManage;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.aim"})
@EnableDiscoveryClient
@MapperScan("com.aim.projectManage.dao")
public class ProjectManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectManageApplication.class, args);
    }

}
