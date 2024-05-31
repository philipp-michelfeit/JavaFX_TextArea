package com.example.javafx_textarea;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Properties;

public class HelloController {
    @FXML
    private Label action;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;

    private static final Properties props = new Properties();

    final String resourceName = "app.properties";

    {
        try (InputStream resourceStream = Objects.requireNonNull(
                HelloController.class.getResourceAsStream(resourceName),
                "File does not exist" ) ) {
            props.load(resourceStream);
        }
        catch ( IOException e ) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void load(){
        txtArea.setText(props.get(txtArea.getId()).toString());
        txtField.setText(props.get(txtField.getId()).toString());
    }

    @FXML
    protected void onSaveButtonClick() throws IOException {
        props.put(txtArea.getId(), txtArea.getText());
        props.put(txtField.getId(), txtField.getText());

        try {
            File file = new File(Objects.requireNonNull(this.getClass().getResource(resourceName)).toURI());
            props.store(new FileOutputStream(file), null);
        }
        catch (IOException | URISyntaxException e ) {
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