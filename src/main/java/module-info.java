module com.example.javafx_textarea {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_textarea to javafx.fxml;
    exports com.example.javafx_textarea;
}