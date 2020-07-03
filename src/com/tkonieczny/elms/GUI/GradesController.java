package com.tkonieczny.elms.GUI;

import com.tkonieczny.elms.classes.Grades;
import com.tkonieczny.elms.classes.UserData;
import com.tkonieczny.elms.http.httpLinking;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class GradesController implements Initializable {
    @FXML
    ListView markList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    private void loadData(){
        Grades.listOfGrades = httpLinking.getListOfGrades();
        ObservableList observableList1 = FXCollections.observableArrayList();
        observableList1.removeAll();

        for(int i = 0 ; i<Grades.listOfGrades.size();i++){
            if(Grades.newGrade.getUserID() == UserData.loggedUser.getUserId() && UserData.loggedUser.getUserId() == Grades.listOfGrades.get(i).getUserID()){
                observableList1.add(Grades.listOfGrades.get(i).toString());

            }
        }
        markList.getItems().addAll(observableList1);
    }
}
