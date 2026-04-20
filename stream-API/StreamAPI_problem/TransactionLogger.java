package com.gla.StreamAPI;
import java.util.*;
import java.time.*;

public class TransactionLogger{
    public static void main(String[] args){
        List<String> ids=Arrays.asList("T1","T2");
        ids.forEach(id->System.out.println(LocalDateTime.now()+" - Transaction: "+id));
    }
}