package com.jaiz.desktop.config;

import com.jaiz.desktop.componet.SomeController;
import com.jaiz.desktop.componet.TestComponent;
import com.jaiz.desktop.view.TestMainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class WarmUp implements ApplicationRunner {

    @Autowired
    private TestComponent tc;

    @Autowired
    private SomeController someController;

    @Autowired
    private FXMLLoader loader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Warm up");
        tc.test();
        someController.test();

        Application.launch(AppEntry.class);

    }

    private static FXMLLoader loaderStatic;

    @PostConstruct
    public void launchApplication(){
        loaderStatic=loader;
    }

    public static class AppEntry extends Application{

        public AppEntry(){
            super();
        }

        @Override
        public void start(Stage stage) throws Exception {


            loaderStatic.setLocation(TestMainController.class.getResource("TestMainController.fxml"));

            AnchorPane root=loaderStatic.load();

            var scene=new Scene(root);

            stage.setScene(scene);

//            stage.setWidth(100);
//            stage.setHeight(100);

            stage.show();
        }
    }
}
