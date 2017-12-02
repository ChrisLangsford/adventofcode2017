package day2;

import fileReader.FileReader;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CheckSumCalculator {
    public static void main(String[] args){
        int checksum = 0;
        List<List<Integer>> inputList = new FileReader("input/day2.txt").readfileIntoListofIntArrays();

        for(List<Integer> row : inputList){
            checksum+= Collections.max(row) - Collections.min(row);
        }

        System.out.println(checksum);
    }
}
