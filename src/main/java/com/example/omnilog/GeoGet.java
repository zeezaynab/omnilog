package com.example.omnilog;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.json.JSONObject;

public class GeoGet {
    @FXML
    private Button enter;
    @FXML
    private Button back;
    @FXML
    private TextField t1;

    public void enter(ActionEvent actionEvent) throws IOException {
        String IP = t1.getText();
        String url = "https://ipinfo.io/" + IP + "/json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(url)).build();
        FXMLLoader loader = new FXMLLoader(HelloController.class.getResource("GeoShow.fxml"));
        Parent mainScreenRoot = loader.load();
        GeoShow controller = loader.getController();
        controller.information(req,client);
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) enter.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("Geo Information");
        stage.show();
    }
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("Main");
        stage.show();
    }
}
