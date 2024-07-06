package com.example.omnilog;

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
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeoShow {

    @FXML
    private Button back;

    @FXML
    private Label l1;

    @FXML
    private TableView<KeyValue> tableview;

    @FXML
    private TableColumn<KeyValue, String> keycolumn;

    @FXML
    private TableColumn<KeyValue, String> valuecolumn;

    @FXML
    public void initialize() {
        keycolumn.setCellValueFactory(new PropertyValueFactory<>("key"));
        valuecolumn.setCellValueFactory(new PropertyValueFactory<>("value"));
    }

    public void information(HttpRequest req, HttpClient client) {
        try {
            HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JSONObject jsonResponse = new JSONObject(response.body());
                l1.setText("Geo Location Information");

                List<KeyValue> ipInfoList = new ArrayList<>();
                ipInfoList.add(new KeyValue("IP", jsonResponse.getString("ip")));
                ipInfoList.add(new KeyValue("City", jsonResponse.getString("city")));
                ipInfoList.add(new KeyValue("Region", jsonResponse.getString("region")));
                ipInfoList.add(new KeyValue("Country", jsonResponse.getString("country")));
                ipInfoList.add(new KeyValue("Location", jsonResponse.getString("loc")));
                ipInfoList.add(new KeyValue("Organization", jsonResponse.getString("org")));
                ipInfoList.add(new KeyValue("Postal", jsonResponse.getString("postal")));
                ipInfoList.add(new KeyValue("Timezone", jsonResponse.getString("timezone")));

                ObservableList<KeyValue> data = FXCollections.observableArrayList(ipInfoList);
                tableview.setItems(data);
            } else {
                l1.setText("Failed to retrieve data. Status Code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GeoGet.fxml"));
        Parent mainScreenRoot = loader.load();
        Scene mainScreenScene = new Scene(mainScreenRoot);
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setScene(mainScreenScene);
        stage.setTitle("Main");
        stage.show();
    }
}
