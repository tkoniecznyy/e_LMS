package com.tkonieczny.elms.GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.net.URL;

public class FxmlLoader {
    private Pane view;

    public Pane getPage(String fileName) {
        try {
            URL fileUrl = MainScene.class.getResource( fileName + ".fxml");
            if(fileUrl==null){
                throw new java.io.FileNotFoundException(" This .FXML file isn't possible to be found");
            }
            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return view;
    }
}
