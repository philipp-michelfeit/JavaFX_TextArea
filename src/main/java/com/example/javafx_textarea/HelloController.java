package com.example.javafx_textarea;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class HelloController {
    @FXML
    private Label action;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;

    private static final Properties props = new Properties();

    final String resourceName = "conf/props.properties";

    {
        try {
            File cwd = Path.of("").toAbsolutePath().toFile();
            if (Path.of("").toAbsolutePath().toString().contains("target")) {

                String base = cwd.getParent();

                props.load(new FileInputStream(new File(base + "/" + resourceName)));
            } else {

                props.load(new FileInputStream(new File(cwd + "/" + resourceName)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void load() {
        txtArea.setText(props.get(txtArea.getId()).toString());
        txtField.setText(props.get(txtField.getId()).toString());
    }

    @FXML
    protected void onSaveButtonClick() throws IOException {
        props.put(txtArea.getId(), txtArea.getText());
        props.put(txtField.getId(), txtField.getText());

        try {
            File cwd = Path.of("").toAbsolutePath().toFile();
            if (Path.of("").toAbsolutePath().toString().contains("target")) {

                String base = cwd.getParent();

                props.load(new FileInputStream(new File(base + "/" + resourceName)));
            } else {

                props.store(new FileOutputStream(new File(cwd + "/" + resourceName)), null);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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