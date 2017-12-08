package day7;

import fileReader.FileReader;

import java.util.*;

public class RecursiveCircus {
    public static void main(String[] args){
        List<List<String>> input = new FileReader("input/day7-test.txt").readFileIntoListOfLines();
        String root = findRootNode(input);
        System.out.println("Root node:"+root);

        Map<String, Node> tree = new HashMap<>();

        for (List<String> nodeLine : input) {
            Node node = new Node(nodeLine.get(0), Integer.parseInt(nodeLine.get(1)), nodeLine.subList(2,nodeLine.size()));
            tree.put(nodeLine.get(0), node);
        }

        System.out.println(tree.get("ugml").children);
        //System.out.println(getTreeWeight(tree, "ugml"));
    }

    public static String findRootNode(List<List<String>> input){
        String root = "";
        Set<String> nodes = new HashSet<>();
        Set<String> children = new HashSet<>();

        for (List<String> nodeLine : input) {
            nodes.add(nodeLine.get(0));
            for (String s : nodeLine.subList(2,nodeLine.size())) {
                children.add(s);
            }
        }

        for (String node : nodes) {
            if(!children.contains(node)){
                root = node;
            }
        }
        return root;
    }

    public static int getTreeWeight(Map<String, Node> tree, String root){
        Node rootNode = tree.get(root);
        int weight = rootNode.weight;
        for (String child : rootNode.children) {
            weight+= getTreeWeight(tree,child);
        }

        return weight;
    }

}
