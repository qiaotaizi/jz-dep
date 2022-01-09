package com.jaiz.desktop.config;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppEntry extends Application {


    public AppEntry() {
        super();
    }

    @Override
    public void start(Stage stage) throws Exception {

        var mainSceneControllerClass= WarmUp.mspStatic.mainSceneControllerClass();
        WarmUp.loaderStatic.setLocation(mainSceneControllerClass.getResource(mainSceneControllerClass.getSimpleName()+".fxml"));
        var root = (Parent) WarmUp.loaderStatic.load();
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


