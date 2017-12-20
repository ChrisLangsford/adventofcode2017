package day7;

import fileReader.FileReader;

import java.util.*;

public class RecursiveCircus {
    public static void main(String[] args){
        List<List<String>> input = new FileReader("input/day7.txt").readFileIntoListOfLines();
        State state = new State();
        for (List<String> lines : input) {
            Node node = new Node(lines.get(0), Integer.parseInt(lines.get(1)), lines.subList(2,lines.size()));
            if(node.children.size() > 0){
                node.children.remove(0);
            }
            state.nodeMap.put(lines.get(0), node);
        }



        //String root = findRootNode(input, state);
        String root = "mkxke";
        System.out.println("Root node: "+root);
        System.out.println("========================================");

        state.buildTreeFromRoot(root);

        Node unbalanced = state.nodeMap.get(recursiveTraverse(state.nodeMap.get(root),state));

        Node unParent = getParentOfUnabalanced(unbalanced, state);

        Set<Integer> childWeights = new HashSet<>();
        for (String child : unParent.children) {
            childWeights.add(getTreeWeight(child, state));
        }

        List<Integer> weightList = new ArrayList<>(childWeights);

        System.out.println("node: "+ unbalanced.name);
        System.out.println("weight: "+ unbalanced.weight);
        System.out.println("needs to be adjusted by");
        System.out.println(weightList.get(0)-weightList.get(1));

    }

    public static Node getParentOfUnabalanced(Node un, State state){
        Node n = un;
        for (Map.Entry<String, Node> nodeEntry : state.nodeMap.entrySet()) {

            if (nodeEntry.getValue().children.contains(un.name)){
                n = nodeEntry.getValue();
            }
        }
        return n;
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

    public static boolean childTreesBalanced(State state, Node root){
        Map<Integer,Integer> weightedFrequencies = new HashMap<>();

        if(root.children.size() <=1){
            return true;
        }

        for (String child : root.children) {
            int key = getTreeWeight(child,state);

            if(weightedFrequencies.containsKey(key)){
                weightedFrequencies.put(key, weightedFrequencies.get(key)+1);
            }else{
                weightedFrequencies.put(key, 1);
            }
        }

        return !(weightedFrequencies.size() > 1);
    }

    public static Node getUnbalancedChild(Node root, State state){
        Map<Integer,Integer> weightedFrequencies = new HashMap<>();
        Map<Integer, Node> treeweights = new HashMap<>();

        for (String child : root.children) {
            int key = getTreeWeight(child,state);
            treeweights.put(getTreeWeight(child,state), state.nodeMap.get(child));

            if(weightedFrequencies.containsKey(key)){
                weightedFrequencies.put(key, weightedFrequencies.get(key)+1);
            }else{
                weightedFrequencies.put(key, 1);
            }
        }
        String unbalancedName = "";
        for (Map.Entry<Integer, Integer> entry : weightedFrequencies.entrySet()) {
            if(entry.getValue() == 1){
                unbalancedName = treeweights.get(entry.getKey()).name;
            }
        }

        return state.nodeMap.get(unbalancedName);

    }

    public static String recursiveTraverse(Node root, State state){
        String name = root.name;

        if(!childTreesBalanced(state, root)){
            //find unbalanced child
            name = recursiveTraverse(getUnbalancedChild(root,state), state);

        }
        return name;
    }



}
