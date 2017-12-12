package day11;

import fileReader.FileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HexGrid {

    public static void main(String[] args){
        List<String> input = new FileReader("input/day11.txt").ReadCSVIntoStrings();

        int x=0,y=0,z=0;

        List<Integer> distances = new ArrayList<>();

        for (String s : input) {
            if(s.equals("n")){
                y++;
                z--;
            }else if(s.equals("s")){
                y--;
                z++;
            } else if (s.equals("ne")){
                x++;
                z--;
            } else if (s.equals("sw")){
                x--;
                z++;
            } else if(s.equals("nw")){
                x--;
                y++;
            } else if (s.equals("se")){
                x++;
                y--;
            }
            distances.add((Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2);
        }

        System.out.println((Math.abs(x) + Math.abs(y) + Math.abs(z)) / 2);

        System.out.println(Collections.max(distances));
    }




}
