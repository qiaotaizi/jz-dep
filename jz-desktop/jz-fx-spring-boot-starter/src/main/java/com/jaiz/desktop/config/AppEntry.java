package com.jaiz.desktop.config;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

public class AppEntry extends Application {


    public AppEntry() {
        super();
    }

    @Override
    public void start(Stage stage) throws Exception {

        var mainSceneControllerClass=LoaderHolder.mspStatic.mainSceneControllerClass();
        LoaderHolder.loaderStatic.setLocation(mainSceneControllerClass.getResource(mainSceneControllerClass.getSimpleName()+".fxml"));
        var root = (Parent)LoaderHolder.loaderStatic.load();
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


