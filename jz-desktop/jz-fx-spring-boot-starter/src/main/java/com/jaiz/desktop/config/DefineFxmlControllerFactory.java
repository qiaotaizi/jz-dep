package com.jaiz.desktop.config;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 改变FXML ControllerFactory
 * 改为从容器里获取
 */
@Configuration
public class DefineFxmlControllerFactory implements ApplicationContextAware {

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
        ac=applicationContext;
    }
}
