package com.tkonieczny.elms.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TeacherPane extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("TeacherScene.fxml"));
        primaryStage.setTitle("Panel Nauczyciela");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}