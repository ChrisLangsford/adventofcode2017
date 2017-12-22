package day7;

import java.util.List;

public class Node {
    public String name;
    public int weight;
    public List<String>children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(List<String> children) {
        this.children = children;
    }

    public Node(String name, int weight, List<String> children) {
        this.name = name;
        this.weight = weight;
        this.children = children;
    }
}
