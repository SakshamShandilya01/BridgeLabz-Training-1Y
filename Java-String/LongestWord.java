package Extras_javaString;
import java.util.Scanner;
public class LongestWord {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        String words[] = sentence.split(" ");
        String longest="";

        for(String word : words){
            if(word.length() > longest.length()){
                longest = word;
            }
        }

        System.out.println("Longest word: " + longest);
    }

}
