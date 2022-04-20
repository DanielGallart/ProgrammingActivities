package com.example.interfazgraficaprueba;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HelloController {
    @FXML
    private Button closeButton, redButton, greenButton, blueButton, yellowButton;
    @FXML
    private Pane mainPane;
    @FXML
    private Label closeText;

    @FXML
    protected void onCloseButtonClick() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void onRedButtonClick(){
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,0,0),null,null)));
    }

    @FXML
    protected void onBlueButtonClick(){
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(0,0,255),null,null)));
    }

    @FXML
    protected void onGreenButtonClick(){
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(0,255,0),null,null)));
    }
    @FXML
    protected void onYellowButtonClick(){
        mainPane.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,0),null,null)));
    }
}