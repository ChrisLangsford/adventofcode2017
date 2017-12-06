package day6;

import fileReader.FileReader;

import java.util.*;


public class MemoryReallocationCounter {
    public static void main(String[] args){
        boolean stopCondition = false;

        boolean counting = false;
        int loopSize = 0;

        int cycleCount =0;
        List<Integer> input = new FileReader("input/day6.txt").readFileIntoIntegerArrayList("\t");
        Set<String> history = new HashSet<>();

        while (!stopCondition) {
            int max = Collections.max(input);
            int maxIndex = input.indexOf(max);
            input.set(maxIndex, 0);

            int loopCounter = 1;
            int e = (maxIndex + 1) % (input.size());

            while (loopCounter <= max) {
                int currVal = input.get(e) + 1;
                input.set(e, currVal);

                loopCounter++;
                e = (e + 1) % (input.size());
            }

            cycleCount++;
            String state = concatenateState(input);
            if(history.contains(state) && !counting){
                counting = true;
                history.clear();
                System.out.println("Cycle count: "+cycleCount);
            } else if (history.contains(state) && counting){
                stopCondition = true;
            } else if(!history.contains(state) && counting){
                history.add(state);
                loopSize++;
            } else if(!history.contains(state) && !counting){
                history.add(state);
            }





        }



        System.out.println("Loop Size: "+ loopSize);
    }

    public static String concatenateState(List<Integer> input){
        String str= "";
        for (Integer i : input) {
            str = str+Integer.toString(i);
        }

        return str;
    }
}


