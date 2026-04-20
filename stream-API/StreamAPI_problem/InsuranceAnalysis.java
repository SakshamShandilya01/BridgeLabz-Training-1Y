package com.gla.StreamAPI;
import java.util.*;
import java.util.stream.*;

class Claim{
    String type; double amount;
    Claim(String t,double a){type=t;amount=a;}
}

public class InsuranceAnalysis{
    public static void main(String[] args){
        List<Claim> list=Arrays.asList(
            new Claim("Health",1000),
            new Claim("Health",2000),
            new Claim("Car",3000)
        );

        Map<String,Double> map=list.stream()
            .collect(Collectors.groupingBy(c->c.type,
                Collectors.averagingDouble(c->c.amount)));

        map.forEach((k,v)->System.out.println(k+" "+v));
    }
}