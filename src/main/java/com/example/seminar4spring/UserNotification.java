package com.example.seminar4spring;


import java.util.ArrayList;

public class UserNotification {
    private final ArrayList<String> notifications = new ArrayList<>();
public void getLog(String s){
    notifications.add(s);
    System.out.println(s);
}

    public ArrayList<String> getNotifications() {
        return notifications;
    }
}
