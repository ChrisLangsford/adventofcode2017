package day7;

import java.util.HashMap;
import java.util.Map;

public class State {
    public Map<String, Node> nodeMap = new HashMap<>();

    public Map<String, Node> tree = new HashMap<>();

    private int _depthCounter = 0;
    public void buildTreeFromRoot(String rootNode){
        Node thisNode = nodeMap.get(rootNode);
        thisNode.setDepth(_depthCounter);
        _depthCounter++;
        tree.put(thisNode.name, thisNode);
        for (String child : thisNode.children) {
            buildTreeFromRoot(child);
        }
    }
}
