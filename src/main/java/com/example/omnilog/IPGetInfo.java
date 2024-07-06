package com.example.omnilog;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class IPGetInfo {
    @FXML
    private Button getdata;
    @FXML
    private TextField inputdata;

    @FXML
    public void getData(ActionEvent event) {
        String IP = inputdata.getText();
        String url = "https://www.whois.com/whois/" + IP;
        try {
            Document doc = Jsoup.connect(url).get();
            Elements data = doc.select(".df-raw");
            String whoIsData = data.text();
            Map<String, String> parsedData = parseWhoisData(whoIsData);
            showOutput(parsedData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, String> parseWhoisData(String data) {
        Map<String, String> parsedData = new LinkedHashMap<>();
        String[] lines = data.split("\n");
        String key = null;

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#") || line.toLowerCase().contains("abuse") || line.toLowerCase().contains("comment")) {
                continue;
            }
            if (line.matches(".*http.*|.*www.*|.*@.*")) {
                continue;
            }
            if (line.contains(":")) {
                String[] parts = line.split(":", 2);
                key = parts[0].trim();
                String value = parts.length > 1 ? parts[1].trim() : "";
                if (!parsedData.containsKey(key)) {
                    parsedData.put(key, value);
                } else {
                    parsedData.put(key, parsedData.get(key) + " " + value);
                }
            } else if (key != null) {
                parsedData.put(key, parsedData.get(key) + " " + line);
            }
        }

        return parsedData;
    }

    private void showOutput(Map<String, String> parsedData) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("IPShowInfo.fxml"));
            Stage stage = (Stage) getdata.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));
            IPShowInfo controller = loader.getController();
            controller.setOutputData(parsedData);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public Button back2;
    public void backM(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) back2.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("IP logger");
        stage.show();

    }
}
