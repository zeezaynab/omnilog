package com.example.omnilog;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    @FXML
    public Button b1;
    public void IPinfo(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IPGetInfo.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) b1.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("IP logger");
        stage.show();
    }
    @FXML
    public Button b2;
    public void URLinfo(ActionEvent actionEvent)throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("URLGetInfo.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) b2.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("IP logger");
        stage.show();
    }
    @FXML
    public Button b3;
    public void Link(ActionEvent actionEvent)throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GeoGet.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) b2.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("IP logger");
        stage.show();
        
    }
}
