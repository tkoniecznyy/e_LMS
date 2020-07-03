package com.tkonieczny.elms.classes;

import com.tkonieczny.elms.http.httpLinking;

import java.util.ArrayList;

public class UserData {
    String login;
    String password;
    Integer userId;
    UserInfo userInfo;
    boolean isTeacher;

    public UserData (String login, String password, Integer userId, UserInfo userInfo, boolean isTeacher){
        this.login = login;
        this.password = password;
        this.userId = userId;
        this.userInfo = userInfo;
        this.isTeacher = isTeacher;
    }
    public UserData (String login, String password){
        this.login = login;
        this.password = password;
    }

    public UserData() {
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Integer getUserId() {
        return userId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public static UserData loggedUser = null;  //aktywny uzytkownik
    public static ArrayList<UserData> listOfUsers = httpLinking.getListOfUsers();  // lista wszystkich userow na serwerze

}
