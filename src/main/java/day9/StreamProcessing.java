package day9;

import fileReader.FileReader;

public class StreamProcessing {
    public static void main(String[] args){
        String input = new FileReader("input/day9.txt").readFileIntoString();

        char[] inp = input.toCharArray();
        boolean garbage = false;
        int score = 0;
        int depth = 1;
        int garbageCount = 0;


        System.out.println(inp.length);

        for (int i = 0; i < inp.length; i++) {
            char c = inp[i];
            if (c == '!'){
                i++;
            } else if (garbage && c !='>') {
                garbageCount++;
            } else if (c == '<') {
                garbage = true;
            } else if (c == '>') {
                garbage = false;
            } else if(c == '{') {
                score += depth++;
            } else if(c == '}') depth--;
        }

        System.out.println("score: "+score);
        System.out.println("Garbage Score: "+garbageCount);

    }
}
