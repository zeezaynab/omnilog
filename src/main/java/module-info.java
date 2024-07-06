module com.example.omnilog {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;
    requires org.json;
    requires java.net.http;


    opens com.example.omnilog to javafx.fxml;
    exports com.example.omnilog;
}