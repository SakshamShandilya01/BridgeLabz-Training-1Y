package com.gla.StreamAPI;
import java.util.*;
import java.util.stream.*;

class Movie {
    String name; double rating; int year;
    Movie(String n,double r,int y){name=n;rating=r;year=y;}
    public String toString(){return name+" "+rating+" "+year;}
}

public class TopTrendingMovies {
    public static void main(String[] args){
        List<Movie> list=Arrays.asList(
            new Movie("A",4.5,2023),
            new Movie("B",4.8,2024),
            new Movie("C",4.2,2022),
            new Movie("D",4.9,2025),
            new Movie("E",4.7,2021),
            new Movie("F",4.6,2023)
        );

        list.stream()
            .sorted((a,b)->Double.compare(b.rating,a.rating))
            .limit(5)
            .forEach(System.out::println);
    }
}