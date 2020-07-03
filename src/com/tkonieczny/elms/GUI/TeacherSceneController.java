package com.tkonieczny.elms.GUI;

import com.tkonieczny.elms.classes.Grades;
import com.tkonieczny.elms.classes.Subjects;
import com.tkonieczny.elms.classes.UserData;
import com.tkonieczny.elms.http.httpLinking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherSceneController implements Initializable {
    @FXML
    ListView<?> listView;
    @FXML
    TextField markTextField, infoTextField, studentID;
    @FXML
    CheckBox mathCheck, biolCheck, chemCheck, polCheck;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();

    }

    private void loadData(){
        ObservableList observableList = FXCollections.observableArrayList();

        observableList.removeAll(observableList);
        for (int i = 0; i< UserData.listOfUsers.size(); i++){
            observableList.add(UserData.listOfUsers.get(i).getUserInfo().getName() + " " + UserData.listOfUsers.get(i).getUserInfo().getSurname() + "  *ID*: "+UserData.listOfUsers.get(i).getUserId());
        }
        listView.getItems().addAll(observableList);
    }

    private Subjects whatSubject(){
        if(mathCheck.isSelected()) return Subjects.sub1;
        if(biolCheck.isSelected()) return Subjects.sub2;
        if(chemCheck.isSelected()) return Subjects.sub3;
        if(polCheck.isSelected()) return Subjects.sub4;
        if(mathCheck.isSelected()==false && biolCheck.isSelected()==false && chemCheck.isSelected()==false && polCheck.isSelected()==false) Alerts.noDataError();
        return null;
    }

    public void addGradeClicked(ActionEvent actionEvent) {
        Grades.newGrade.setTeacher(UserData.loggedUser.getUserInfo().getName()+" "+UserData.loggedUser.getUserInfo().getSurname());
        Grades.newGrade.setInfo(infoTextField.getText());
        Grades.newGrade.setMark(Double.parseDouble(markTextField.getText()));
        Grades.newGrade.setSubject(whatSubject());
        Grades.newGrade.setUserID(Integer.parseInt(studentID.getText()));
        Boolean response = httpLinking.sendGradeToServer(Grades.newGrade);
        if (response==true) Alerts.allIsOKDialog();

    }
}

