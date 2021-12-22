package com.jaiz.desktop.view;

import com.jaiz.desktop.annotation.FXMLController;
import com.jaiz.desktop.componet.SomeController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class TestMainController {

    @FXML
    public Button helloBtn;

    @Autowired
    private SomeController someController;


    public void sayHello(ActionEvent actionEvent) {
        someController.test();
    }
}
