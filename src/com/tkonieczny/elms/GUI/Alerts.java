package com.tkonieczny.elms.GUI;

import javafx.scene.control.Alert;

public class Alerts {


    static public void loginError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("BLĘDNY LOGIN LUB HASŁO");
        errorAlert.setContentText("Proszę sprawdzić poprawność loginu i hasła, a nstępnie spróbowac ponownie!");
        errorAlert.showAndWait();
    }
  /*  static public void allIsOKDialog(){
        Alert allIsOK= new Alert(Alert.AlertType.CONFIRMATION);
        allIsOK.setTitle("Potwierdzenie złożenia rezerwacji");
        allIsOK.setHeaderText("Rezerwacja dokonana pomyślnie!");
        allIsOK.setContentText("Rezewacja przebiegła pomyślnie! Dziękujemy i życzymy miłego seansu :) \n\nPrzypominamy o konieczności uiszczenia opłaty nie póżniej niż 15min przed rozpoczęciem seansu.");
        allIsOK.showAndWait();


    }

    static public void noFilmError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("NIE WYBRANO FILMU");
        errorAlert.setContentText("Proszę wcisnąć obrazek (po lewej stronie) z filmem, na który dokonywana jest rezerwacja i spróbowac ponownie!");
        errorAlert.showAndWait();
    }

    static public void noDataError(){
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("BRAK DANYCH");
        errorAlert.setContentText("Proszę uzupełnić wszytskie pola z danymi dokonującego rezerwacji i spróbowac ponownie!");
        errorAlert.showAndWait();
    }
    static public void sameSeatsAreReservedError() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("TE MIEJSCA SA JUZ ZAJETE");
        errorAlert.setContentText("Miejsca wybrane przez Pana/Panią są juz zajęte przez innego użytkownika!\nProszę wybrać inne miejsca na sali.");
        errorAlert.showAndWait();
    } */
}
