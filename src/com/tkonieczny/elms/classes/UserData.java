package com.tkonieczny.elms.classes;

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
}
