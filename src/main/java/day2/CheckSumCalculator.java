package day2;

import fileReader.FileReader;

import java.util.Collections;
import java.util.List;

public class CheckSumCalculator {
    public static void main(String[] args){
        int part1 = 0;
        int part2 = 0;
        List<List<Integer>> inputList = new FileReader("input/day2.txt").readfileIntoListofIntArrays();

        for(List<Integer> row : inputList){
            part1 += Collections.max(row) - Collections.min(row);

            for(int i=0; i< row.size(); i++){
                for(int j=0; j < row.size(); j++){
                    if(i !=j && row.get(i)%row.get(j)==0){
                        part2+=row.get(i)/row.get(j);
                    }
                }
            }
        }

        System.out.println("Part 1: "+ part1);
        System.out.println("Part 2: "+ part2);
    }
}
