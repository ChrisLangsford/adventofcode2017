package day7_2;

import fileReader.FileReader;

import java.util.List;
import java.util.Map;

public class RecursiveCircus {

    public static void main(String[] args){
        List<List<String>> input = new FileReader("input/day7.txt").readFileIntoListOfLines();
        State state = new State();

        for (List<String> line : input) {
            String name = line.get(0);
            int weight = Integer.parseInt(line.get(1));
            List<String> childList = line.subList(2,line.size());

            state.names.add(name);
            state.children.put(name, childList);

            for (String child : childList) {
                state.parents.put(child,name);
            }
            state.weights.put(name,weight);
        }

        for (String name : state.names) {
            //Part A
           if (!state.parents.containsKey(name)){
               state.root = name;
           }
        }
        System.out.println("Root Node: "+ state.root);
        computeSumWeights(state.root, state);

        for (String name : state.names) {
            if(!isBalanced(name,state)) continue;
            if(!state.parents.containsKey(name)) continue;

            List<String> siblings = state.children.get(state.parents.get(name));
            if(siblings.size() < 3) continue;

            int mySumWeight = state.sumWeights.get(name);
            int differentSiblings = 0;
            int siblingsSumWeight = 0;

            for (String sibling : siblings) {
                if(state.sumWeights.get(sibling) !=mySumWeight){
                    differentSiblings++;
                    siblingsSumWeight += state.sumWeights.get(sibling);
                }
            }
            if(differentSiblings >= 2){
                int result = state.weights.get(name) + siblingsSumWeight - mySumWeight;
                System.out.println(result);
            }
        }

    }

    public static void computeSumWeights(String name, State s){
        int sumWeight = s.weights.get(name);

        for (String child : s.children.get(name)) {
            computeSumWeights(child,s);
            sumWeight += s.sumWeights.get(child);
        }
        s.sumWeights.put(name,sumWeight);
    }

    public static boolean isBalanced(String name, State s){
        boolean result = true;
        List<String> ch = s.children.get(name);
        if(ch.size() < 2) {
            result = true;
        } else {
            int expectedSumWeight = s.sumWeights.get(ch.get(0));
            for (String c : ch) {
                if(s.sumWeights.get(c) != expectedSumWeight){
                    System.out.println(s.sumWeights.get(c) +" vs "+ expectedSumWeight );
                    int out = s.weights.get(ch.get(0)) - (expectedSumWeight - s.sumWeights.get(c));
                    System.out.println(ch + " would need to weigh: "+ out);
                    result = false;
                }
            }
        }
        return result;
    }
}
