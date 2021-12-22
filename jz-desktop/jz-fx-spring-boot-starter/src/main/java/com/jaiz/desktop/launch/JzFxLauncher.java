package com.jaiz.desktop.launch;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.jaiz.desktop")
public class JzFxLauncher {

    public static void launch(Class<? extends Application> appClass,String[] args){
        SpringApplication.run(JzFxLauncher.class,args);
    }

}
