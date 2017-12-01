package day1;


import fileReader.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaptchaSolver {

    public static void main(String args[]){
        List<Integer> inputNumber = new FileReader("input/day1.txt").readFileIntoIntegerArrayList();
        int sum = 0;
        //int jump = 1; // Part 1
        int jump = inputNumber.size()/2; // Part 2

        for(int i=0; i < inputNumber.size(); i++){
            if(inputNumber.get(i).equals(inputNumber.get(wrapIndex(inputNumber.size(), i+jump)))){
                sum+=inputNumber.get(i);
                System.out.println("size: "+ inputNumber.size());
            }

        }
        System.out.println(sum);

    }

    private static int wrapIndex(int maxSize, int currentIndex){
        if (currentIndex >= maxSize){
            return currentIndex-maxSize;
        } else {
            return currentIndex;
        }
    }
}
