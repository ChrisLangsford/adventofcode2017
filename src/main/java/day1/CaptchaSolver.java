package day1;


import fileReader.FileReader;

public class CaptchaSolver {

    public static void main( String args[]){
        String input  = new FileReader("input/day1.txt").readFileIntoString();
        System.out.println(input);

    }
}
