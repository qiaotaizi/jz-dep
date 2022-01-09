package com.jaiz.desktop.config;

import com.jaiz.desktop.componet.AppConfigManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class WarmUp implements ApplicationRunner {

    private final FXMLLoader loader;

    private final MainSceneProvider mainSceneProvider;

    private final AppConfigManager appConfigManager;

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
