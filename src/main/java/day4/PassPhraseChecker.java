package day4;

import fileReader.FileReader;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassPhraseChecker {

    public static void main(String[] args){
        List<List<String>> input = new FileReader("input/day4.txt").readFileIntoListOfLines();
        int part1 = 0;
        int part2 = 0;
        boolean valid = true;

        for(List<String> line : input){
            Set<String> set = new HashSet<>(line);
            if(line.size() == set.size()){
                part1++;
                if(noAnagrams(line)){
                    part2++;
                }
            }

        }



        System.out.println("Part 1: "+ part1);
        System.out.println("Part 2: "+ part2);

    }

    public static boolean anagramCheck(String a, String b) {
        boolean anagramFound = false;

        char[] c = a.toCharArray();
        char[] d = b.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);

        String e = new String(c);
        String f = new String(d);

        if(e.equals(f)){
            anagramFound = true;
        }

        return anagramFound;
    }

    public static boolean noAnagrams(List<String> s) {
        for (int i = 0; i < s.size() - 1; i++) {
            for (int j = i + 1; j < s.size(); j++) {
                if (anagramCheck(s.get(i), s.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
