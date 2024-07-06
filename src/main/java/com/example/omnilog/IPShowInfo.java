package com.example.omnilog;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class IPShowInfo {
    @FXML
    private TableView<KeyValuePairs> tableView;
    @FXML
    private TableColumn<KeyValuePairs, String> keyColumn;
    @FXML
    private TableColumn<KeyValuePairs, String> valueColumn;

    @FXML
    public void initialize() {
        keyColumn.setCellValueFactory(new PropertyValueFactory<>("key"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    }

    public void setOutputData(Map<String, String> data) {
        ObservableList<KeyValuePairs> items = FXCollections.observableArrayList();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            items.add(new KeyValuePairs(entry.getKey(), entry.getValue()));
        }
        tableView.setItems(items);
    }
    @FXML
    public Button back;
    public void backtomenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("IPGetInfo.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("IP logger");
        stage.show();
    }
}

