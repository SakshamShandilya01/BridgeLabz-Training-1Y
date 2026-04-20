package com.gla.StreamAPI;
import java.util.*;

public class StockLogger{
    public static void main(String[] args){
        List<Double> prices=Arrays.asList(100.5,101.2,99.8);
        prices.forEach(System.out::println);
    }
}