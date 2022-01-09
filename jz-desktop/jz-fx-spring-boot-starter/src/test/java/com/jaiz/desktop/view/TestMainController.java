package com.jaiz.desktop.view;

import com.jaiz.desktop.annotation.FXMLController;
import com.jaiz.desktop.config.MainSceneProvider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class TestMainController implements MainSceneProvider {

    @FXML
    public Button helloBtn;

    @FXML
    public AnchorPane rootPane;

    @Override
    public Class<TestMainController> mainSceneControllerClass() {
        return TestMainController.class;
    }

    public void sayHello(ActionEvent actionEvent) {
        System.out.println("hello");
        System.out.println(rootPane.getHeight()+","+rootPane.getWidth());
    }
}
