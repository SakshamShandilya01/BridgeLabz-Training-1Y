package com.gla.StreamAPI;
import java.util.*;

public class EmailNotifications{
    static void sendEmailNotification(String email){
        System.out.println("Sent to "+email);
    }

    public static void main(String[] args){
        List<String> emails=Arrays.asList("a@gmail.com","b@gmail.com");
        emails.forEach(e->sendEmailNotification(e));
    }
}