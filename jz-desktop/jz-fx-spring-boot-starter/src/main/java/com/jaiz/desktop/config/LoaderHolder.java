package com.jaiz.desktop.config;

import com.jaiz.desktop.ex.DesktopException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LoaderHolder implements ApplicationRunner {

    @Autowired
    private FXMLLoader loader;

    @Autowired
    private MainSceneProvider mainSceneProvider;

    /**
     * FX应用启动
     * @param args 命令行参数
     * @throws Exception 异常抛出
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Application.launch(AppEntry.class);

    }

    static FXMLLoader loaderStatic;

    static MainSceneProvider mspStatic;

    @PostConstruct
    public void launchApplication(){
        loaderStatic=loader;
        mspStatic=mainSceneProvider;
    }

}
