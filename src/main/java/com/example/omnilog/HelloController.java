package com.example.omnilog;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private Button start;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) start.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("IP logger");
        stage.show();

    }
}