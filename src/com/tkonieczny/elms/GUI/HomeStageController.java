package com.tkonieczny.elms.GUI;

import com.tkonieczny.elms.classes.UserData;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class HomeStageController implements Initializable {
    @FXML
    private Text dateHomeStage, timeHomeStage;
    @FXML
    private Button clockButton;
    @FXML
    private Text nameOfUserText, emailText, privilegesText;


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
        loadData();


    }

    public void openTeacherPanel(ActionEvent actionEvent) throws Exception {
        if ( UserData.loggedUser.isTeacher() == false){
            System.out.println(UserData.loggedUser.toString());
            Alerts.privilegesError();
        }
        else{
            TeacherPane pane = new TeacherPane();
            pane.start(new Stage());
        }

    }

    public void loadData(){
        nameOfUserText.setText(UserData.loggedUser.getUserInfo().getName() + " " + UserData.loggedUser.getUserInfo().getSurname());
        emailText.setText(UserData.loggedUser.getUserInfo().getEmail());
        if(UserData.loggedUser.getUserId()==6 ||UserData.loggedUser.getUserId()==7 ) {
            UserData.loggedUser.setTeacher(true); ////////////////
            privilegesText.setText("NAUCZYCIEL");
        }
        else privilegesText.setText("UCZEŃ");

    }
}
