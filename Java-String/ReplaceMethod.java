package Extras_javaString;
import java.util.Scanner;
public class ReplaceMethod {
        public static void main(String[] args) {

            String str="Hello World";
            char oldChar='o';
            char newChar='a';

            String result="";

            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);

                if(ch==oldChar)
                    result += newChar;
                else
                    result += ch;
            }

            System.out.println(result);
        }
}
