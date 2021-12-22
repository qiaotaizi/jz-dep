package com.jaiz.desktop.config;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AppContAware implements ApplicationContextAware {

    private ApplicationContext ac;

    @Bean
    public FXMLLoader loader(){
        System.out.println("loader");
        var loader = new FXMLLoader();
        loader.setControllerFactory(ac::getBean);
        return loader;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
        ac=applicationContext;
    }
}
