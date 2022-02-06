package com.yuancheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描mybaits 通用 mapper所在的包
@MapperScan(basePackages = "com.yuancheng.mapper")
//扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.yuancheng","org.n3r.idworker"})
//@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
