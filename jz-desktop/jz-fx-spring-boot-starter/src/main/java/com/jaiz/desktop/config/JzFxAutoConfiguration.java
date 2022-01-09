package com.jaiz.desktop.config;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 改变FXML ControllerFactory
 * 改为从容器里获取
 *
 * 初始化一些bean
 */
@Configuration
public class JzFxAutoConfiguration implements ApplicationContextAware {

    private ApplicationContext ac;

    @Bean
    public FXMLLoader loader(){
        var loader = new FXMLLoader();
        loader.setControllerFactory(ac::getBean);
        return loader;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ac=applicationContext;
    }

    @Bean
    @ConfigurationProperties(prefix = "jz.fx")
    public JzFxProperties initCB(){
        return new JzFxProperties();
    }




}
