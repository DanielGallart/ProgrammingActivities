package com.example.interfazgraficaprueba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 340);
        stage.setTitle("Daniel Gallart");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws InterruptedException{

    }

    public static void main(String[] args) {
        launch();
    }
}