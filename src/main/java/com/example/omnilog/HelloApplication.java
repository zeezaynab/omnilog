package com.example.omnilog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Omnilog");





















        Image icon = new Image("file:///C:/Users/Zainab/IdeaProjects/Omnilog/src/main/resources/456.png");
        stage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        launch();
    }
}
