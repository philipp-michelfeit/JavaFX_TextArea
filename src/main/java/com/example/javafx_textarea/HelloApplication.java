package com.example.javafx_textarea;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("app.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 284);
        stage.setTitle("Squish - TextArea vs TextField save example");
        stage.setScene(scene);
        stage.setOnShowing(event -> {
            HelloController con = fxmlLoader.getController();
            con.load();
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}