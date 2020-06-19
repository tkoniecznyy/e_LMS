package com.tkonieczny.elms.GUI;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;


public class MainSceneController implements Initializable {
    @FXML
    private BorderPane contentPane;
    @FXML
    private Text dateHomeStage, timeHomeStage;
    @FXML
    private Button clockButton;


    public void homeStageAction(MouseEvent mouseEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("HomeStage");
        contentPane.setCenter(view);
    }
    public void gradesStageAction(MouseEvent mouseEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("GradesStage");
        contentPane.setCenter(view);
    }
    public void chatStageAction(MouseEvent mouseEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("ChatStage");
        contentPane.setCenter(view);
    }
    public void EduStageAction(MouseEvent mouseEvent) {
        FxmlLoader object = new FxmlLoader();
        Pane view = object.getPage("EduStage");
        contentPane.setCenter(view);
    }

    private void showDateHomeStage(){
        //Date
      //  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      //  Date date = new Date();
      //  dateHomeStage.setText(dateFormat.format(date));
        //Time
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            LocalDate currDate = LocalDate.now();
            timeHomeStage.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
            dateHomeStage.setText(currDate.getDayOfMonth() + "."+ currDate.getMonthValue() + "." + currDate.getYear() +"r.");
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    public void showClockOnNewStage(ActionEvent actionEvent) {
        Clock clock = new Clock();
        try {
            clock.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showDateHomeStage();


    }


}
