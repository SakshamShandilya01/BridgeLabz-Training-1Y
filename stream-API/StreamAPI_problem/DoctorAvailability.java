package com.gla.StreamAPI;
import java.util.*;

class Doctor{
    String name,day,specialty;
    Doctor(String n,String d,String s){name=n;day=d;specialty=s;}
}

public class DoctorAvailability{
    public static void main(String[] args){
        List<Doctor> list=Arrays.asList(
            new Doctor("Dr A","Saturday","Cardio"),
            new Doctor("Dr B","Monday","Neuro"),
            new Doctor("Dr C","Sunday","Ortho")
        );

        list.stream()
            .filter(d->d.day.equals("Saturday")||d.day.equals("Sunday"))
            .sorted((a,b)->a.specialty.compareTo(b.specialty))
            .forEach(d->System.out.println(d.name+" "+d.specialty));
    }
}