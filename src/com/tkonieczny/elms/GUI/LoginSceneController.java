package com.tkonieczny.elms.GUI;

import com.tkonieczny.elms.classes.LoginInfo;
import com.tkonieczny.elms.classes.UserData;
import com.tkonieczny.elms.http.httpLinking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class LoginSceneController {

    @FXML
    TextField loginTextField;
    @FXML
    PasswordField passwordText;


    public void loginButtonClicked(ActionEvent actionEvent) throws IOException {
       Boolean authOfLogin =  httpLinking.getAuthOfLogin(new LoginInfo(loginTextField.getText(),passwordText.getText()));
        if (authOfLogin == true){
            MainScene sceneAfterLog = new MainScene();
            sceneAfterLog.start(new Stage());
        }
        else{
            Alerts.loginError();
        }
    }
}
