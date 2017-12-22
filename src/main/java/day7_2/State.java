package day7_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

    public List<String> names = new ArrayList<>();
    public Map<String, List<String>> children = new HashMap<>();
    public Map<String, String> parents = new HashMap<>();
    public Map<String, Integer> weights = new HashMap<>();

    public String root = null;

    public Map<String, Integer> sumWeights = new HashMap<>();


}
