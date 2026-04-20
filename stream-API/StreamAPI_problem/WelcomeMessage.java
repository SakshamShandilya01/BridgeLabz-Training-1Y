package com.gla.StreamAPI;
import java.util.*;

public class WelcomeMessage{
    public static void main(String[] args){
        List<String> list=Arrays.asList("A","B","C");
        list.forEach(n->System.out.println("Welcome "+n));
    }
}