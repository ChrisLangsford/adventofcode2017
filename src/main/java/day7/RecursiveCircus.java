package day7;

import fileReader.FileReader;

import java.util.*;

public class RecursiveCircus {
    public static void main(String[] args){
        List<List<String>> input = new FileReader("input/day7-test.txt").readFileIntoListOfLines();
        State state = new State();
        for (List<String> lines : input) {
            Node node = new Node(lines.get(0), Integer.parseInt(lines.get(1)), lines.subList(2,lines.size()));
            if(node.children.size() > 0){
                node.children.remove(0);
            }
            state.nodeMap.put(lines.get(0), node);
        }

        String root = findRootNode(input, state);
        System.out.println("Root node: "+root);
        System.out.println("========================================");

        System.out.println(getTreeWeight("ugml", state));
    }

    public static String findRootNode(List<List<String>> input, State s){
        Set<String> nodes = new HashSet<>(s.nodeMap.keySet());
        Set<String> childNodes = new HashSet<>();

        for (Map.Entry<String,Node> entry : s.nodeMap.entrySet()) {
            for (String child : entry.getValue().children) {
                childNodes.add(child);
            }
        }
        childNodes.removeAll(Arrays.asList("", null));
        nodes.removeAll(childNodes);
        return nodes.iterator().next();
    }

    public static int getTreeWeight(String root, State s){
        Node rootNode = s.nodeMap.get(root);
        int weight = rootNode.weight;
        for (String child : rootNode.children) {
            weight+= getTreeWeight(child, s);
        }

        return weight;
    }

}
