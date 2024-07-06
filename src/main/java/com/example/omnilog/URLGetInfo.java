package com.example.omnilog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class URLGetInfo {
    @FXML
    private TextField T1;
    @FXML
    private Button S1;
    @FXML
    private Button b1;

    public void Search (ActionEvent actionEvent) throws IOException {
        String Domain = T1.getText();
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("URLShowInfo.fxml"));
        Parent mainScreenRoot = loader.load();
        URLShowInfo controller = loader.getController();
        controller.info(Domain);
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) S1.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("Domain Information");
        stage.show();
    }
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) b1.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("Main");
        stage.show();
    }
}
