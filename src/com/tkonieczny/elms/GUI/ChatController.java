package com.tkonieczny.elms.GUI;

import com.tkonieczny.elms.classes.UserData;
import com.tkonieczny.elms.http.httpLinking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    @FXML
    ListView<String> listUserDisplay;
    @FXML
    TextField textMessage;
    @FXML
    Button sendMessageButton;
    @FXML
    TextArea messagesTextArea;

    ObservableList observableList = FXCollections.observableArrayList();

    private void loadData(){
        observableList.removeAll(observableList);
        for (int i=0;i<UserData.listOfUsers.size();i++){
            observableList.add(UserData.listOfUsers.get(i).getUserInfo().getName() + " " + UserData.listOfUsers.get(i).getUserInfo().getSurname());
        }
        listUserDisplay.getItems().addAll(observableList);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();

    }

    public void sendMessageButtonClicked(ActionEvent actionEvent) {
        LocalTime currentTime = LocalTime.now();
        LocalDate currDate = LocalDate.now();
        String mess = null;
        Boolean response = false;
        if(textMessage.getText().isEmpty()){
            Alerts.messError();
        }
        else {
            if (UserData.loggedUser.isTeacher() == true) {
                 mess = "Data: " + currDate.getDayOfMonth() + "." + currDate.getMonthValue() + "." + currDate.getYear() + "r. " +
                        "   Godzina: " + currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond() + "   " +
                        "*** Odpowiedź od nauczyciela *** : " + UserData.loggedUser.getUserInfo().getName() + " " + UserData.loggedUser.getUserInfo().getSurname() + ":  "+textMessage.getText();
            } else {
                 mess = "Data: " + currDate.getDayOfMonth() + "." + currDate.getMonthValue() + "." + currDate.getYear() + "r. " +
                        "   Godzina: " + currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond() + "   " +
                        UserData.loggedUser.getUserInfo().getName() + " " + UserData.loggedUser.getUserInfo().getSurname() + ":  "+textMessage.getText()+" ";

            }
           if(mess!=null) response = httpLinking.sendMessageToServer(mess);
           if(mess==null) Alerts.messConnectionError();
        }
        if(response == true){
            ArrayList<String> messagesFromServer = httpLinking.getListOfMessages();
           messagesTextArea.setText("-Chat- \n");
                   for(int i=0;i<messagesFromServer.size();i++){
                       messagesTextArea.appendText(messagesFromServer.get(i));
                       messagesTextArea.appendText("\n\n");

            };
        }
        if(response == false){
            Alerts.messConnectionError();
        }
    }
}
