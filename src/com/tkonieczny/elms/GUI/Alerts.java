package com.tkonieczny.elms.GUI;

import javafx.scene.control.Alert;

public class Alerts {


    static public void loginError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("BLĘDNY LOGIN LUB HASŁO");
        errorAlert.setContentText("Proszę sprawdzić poprawność loginu i hasła, a nstępnie spróbowac ponownie!");
        errorAlert.showAndWait();
    }

    static public void messError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("NIE WPISANO TREŚCI WIADMOSĆI");
        errorAlert.setContentText("Pole wiadomości jest puste, wpisz jakąś wiadmość a następnie ponów próbę!");
        errorAlert.showAndWait();
    }

    static public void messConnectionError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("BŁĄD PODCZAS WYSYŁANIA WIADOMOŚCI");
        errorAlert.setContentText("Wystąpił błąd podczas wysyłania wiadomości - sprawdź swoje połączenie a następnie ponów próbę");
        errorAlert.showAndWait();
    }


    static public void privilegesError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("BRAK UPRAWNIEŃ");
        errorAlert.setContentText("Nie posiadasz uprawnień do otwarcia tego panelu - jeżeli jesteś nauczycielem skontaktuj się z administratorem");
        errorAlert.showAndWait();
    }


     static public void allIsOKDialog(){
        Alert allIsOK= new Alert(Alert.AlertType.CONFIRMATION);
        allIsOK.setTitle("Potwierdzenie dodania oceny");
        allIsOK.setHeaderText("Ocena dodana pomyślnie!");
        allIsOK.setContentText("Dodałeś/aś ocenę pomyślnie! \n\n Możesz zamknąć okno panelu");
        allIsOK.showAndWait();


    }

    static public void noDataError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("BRAK DANYCH");
        errorAlert.setContentText("Proszę wypełnić wszytskie pola oraz zaznaczyć przedmiot i spróbowac ponownie!");
        errorAlert.showAndWait();
    }

}
