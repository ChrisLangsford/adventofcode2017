package day5;

import fileReader.FileReader;

import java.util.List;

public class InstructionJumper {
    public static void main(String[] args){
        List<Integer> input = new FileReader("input/day5.txt").readLinesIntoIntegerArrayList();

        int stepCount = 0;
        int position = 0;
        int offset = 1;

        while(position >= 0 && position < input.size()){
            int currentVal = input.get(position);
            offset = (currentVal) < 3 ?  1 :  -1; //Part 2
            int newVal = currentVal + offset;
            input.set(position,newVal);
            position += currentVal;
            stepCount++;
        }
        System.out.println("Step Count: "+stepCount);


    }
}
