package com.gla.StreamAPI;
import java.util.function.Consumer;

public class SmartHomeLighting {
    public static void main(String[] args) {
        Consumer<String> motion = room -> System.out.println("Motion detected in " + room + ": Lights ON");
        Consumer<String> night = room -> System.out.println("Night mode in " + room + ": Dim Lights");
        Consumer<String> voice = room -> System.out.println("Voice command in " + room + ": Lights OFF");

        motion.accept("Living Room");
        night.accept("Bedroom");
        voice.accept("Kitchen");
    }
}