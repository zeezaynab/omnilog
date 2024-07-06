package com.example.omnilog;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class URLShowInfo extends Application {

    @FXML
    private Button b;

    @FXML
    private Label L1;

    @FXML
    private TableView<KeyValue> tableView;

    @FXML
    private TableColumn<KeyValue, String> KeyColumn;

    @FXML
    private TableColumn<KeyValue, String> ValueColumn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("URLGetInfo.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Domain Info");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @FXML
    public void initialize() {
        KeyColumn.setCellValueFactory(new PropertyValueFactory<>("key"));//Initialize karyega
        ValueColumn.setCellValueFactory(new PropertyValueFactory<>("value")); //convenient way to specify that the data displayed in this column (KeyColumn) should be taken from a property named "key" in the objects displayed in the TableView's rows.
    }

    public void info(String Domain) throws IOException {
        String url = "https://www.whois.com/whois/" + Domain + ".com";
        Document document = Jsoup.connect(url).get();
        Element headingElement = document.selectFirst(".df-heading");
        if (headingElement != null) {
            String headingText = headingElement.text();
            L1.setText(headingText);
        } else {
            L1.setText("No information found for the domain: " + Domain);
            return;
        }

        Elements rows = document.select(".df-row");
        ObservableList<KeyValue> data = FXCollections.observableArrayList();//Observable list woh data hold krti ha that can be observed for changes or ess main key class ha matlab key clas ky objects hold krega and object changes ko note karega
        //Dynamic loading main use hoti ha observable list
        for (Element row : rows) {
            Element labelElement = row.selectFirst(".df-label");
            Element valueElement = row.selectFirst(".df-value");
            if (labelElement != null && valueElement != null) {
                String label = labelElement.text();
                String value = valueElement.text();
                data.add(new KeyValue(label, value));//This line creates a new instance of the KeyValue class using the extracted label and value, and then adds this instance to the data list.
            }
        }

        tableView.setItems(data);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("URLGetInfo.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) b.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("Url");
        stage.show();
    }

    public static class KeyValue {
        private String key;
        private String value;

        public KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
