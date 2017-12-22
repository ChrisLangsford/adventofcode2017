package day7;

import fileReader.FileReader;

import java.util.*;

public class RecursiveCircus {
    public static void main(String[] args){
        List<List<String>> input = new FileReader("input/day7.txt").readFileIntoListOfLines();
        State state = new State();
        for (List<String> lines : input) {
            Node node = new Node(lines.get(0), Integer.parseInt(lines.get(1)), lines.subList(2,lines.size()));
            state.nodeMap.put(node.name, node);
        }



        String root = findRootNode(state);
        System.out.println("Root node: "+root);
        System.out.println("========================================");

        Node unbalanced = state.nodeMap.get(recursiveTraverse(state.nodeMap.get(root),state));

        Node unParent = getParentOfUnbalanced(unbalanced, state);

        Set<Integer> childWeights = new HashSet<>();
        for (String child : unParent.children) {
            childWeights.add(getTreeWeight(child, state));
        }

        List<Integer> weightList = new ArrayList<>(childWeights);

        System.out.println("node: "+ unbalanced.name);
        System.out.println("weight: "+ unbalanced.weight);
        System.out.println("needs to be adjusted by");
        int diff = weightList.get(0)-weightList.get(1);
        System.out.println(diff);
        int newWeight = unbalanced.weight + diff;
        System.out.println("new weight: " + newWeight);

    }

    public static Node getParentOfUnbalanced(Node un, State state){
        Node n = un;
        for (Map.Entry<String, Node> nodeEntry : state.nodeMap.entrySet()) {

            if (nodeEntry.getValue().children.contains(un.name)){
                n = nodeEntry.getValue();
            }
        }
        return n;
    }




    public static String findRootNode(State s){
        Set<String> nodes = new HashSet<>(s.nodeMap.keySet());
        Set<String> childNodes = new HashSet<>();

        for (String node : s.nodeMap.keySet()) {
            for (String child : s.nodeMap.get(node).children) {
                childNodes.add(child);
            }
        }
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
            name = recursiveTraverse(getUnbalancedChild(root,state), state);
        }
        return name;
    }



}
