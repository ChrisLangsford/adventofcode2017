package day3;

import fileReader.FileReader;

public class SpiralMemoryStepCounter {

    public static void main(String[] args){
        int input = new FileReader("input/day3.txt").ReadSingleIntegerValueFromFile();
        int part1 = 0;
        int part2 = 0;


        int bottomRightCorner = getBottomRightCorner(input);

        int distanceTo1 = (int) Math.sqrt(bottomRightCorner)-1;
        int distanceToCorner = bottomRightCorner-input;
        int x = distanceToCorner/2;

        part1 = x + (distanceToCorner-x);
        //part 2 no-coded in excel :P


        System.out.println("input: "+ input);
        System.out.println("bottom right corner: "+bottomRightCorner);
        System.out.println("distance to right corner: "+ distanceToCorner);
        System.out.println("corner distance to 1: "+ distanceTo1);
        System.out.println("part 1: "+ part1);
        System.out.println("part 2: "+ part2);

    }

    static boolean isOddPerfectSquare(int i) {
        if(i%2==0) return false;

        int sqrt = (int) Math.sqrt(i);

        return sqrt*sqrt == i;
    }

    static int getBottomRightCorner(int input){
        int distanceToSquare =0;
        while (!isOddPerfectSquare(input+distanceToSquare)){
            distanceToSquare++;
        }
        return input+distanceToSquare;
    }

}
