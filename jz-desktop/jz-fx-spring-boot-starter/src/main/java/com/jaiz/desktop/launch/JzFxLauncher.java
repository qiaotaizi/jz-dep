package com.jaiz.desktop.launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.jaiz.desktop")
public class JzFxLauncher {

    public static void launch(String[] args){
        SpringApplication.run(JzFxLauncher.class,args);
    }

}
