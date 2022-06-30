package com.aim.QuestionnaireManage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication(scanBasePackages = {"com.aim"})
@EnableScheduling
@EnableCaching
@EnableAsync
@EnableDiscoveryClient
@MapperScan("com.aim.QuestionnaireManage.dao")
public class QuestionnaireManageApplication {
  public static void main(String[] args) {
    SpringApplication.run(QuestionnaireManageApplication.class, args);
  }
}
