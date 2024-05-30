package com.example.javafx_textarea;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Properties;

public class HelloController {
    @FXML
    private Label action;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;

    private static final Properties props = new Properties();

    private static final String propsFile = "src/main/resources/com/example/javafx_textarea/app.properties";

    public HelloController() {
        init();
    }

    public void init(){
        try {
            props.load(new FileInputStream(propsFile));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void load(){
        txtArea.setText(props.get(txtArea.getId()).toString());
        txtField.setText(props.get(txtField.getId()).toString());
    }

    @FXML
    protected void onSaveButtonClick() throws IOException {
        props.put(txtArea.getId(), txtArea.getText());
        props.put(txtField.getId(), txtField.getText());
        props.store(new FileOutputStream(propsFile), null);
        action.setText("Saved !");

    }

    @FXML
    protected void onLoadButtonClick() {
        load();
        action.setText("Loaded !");
    }

    @FXML
    protected void onClearButtonClick() {
        txtArea.clear();
        txtField.clear();
        action.setText("Cleared all fields !");
    }
}