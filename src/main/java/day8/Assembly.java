package day8;

import fileReader.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assembly {
    public  static void main(String[] args){
        List<List<String>> input = new FileReader("input/day8.txt").readFileIntoListOfLines();
        State state = new State();

        for (List<String> strings : input) {
            state.registerMap.put(strings.get(0), new Register(strings.get(0),0));
            Condition condition = new Condition(strings.get(3), strings.get(4), Integer.parseInt(strings.get(5)));
            Instruction instruction = new Instruction(strings.get(0), strings.get(1),Integer.parseInt(strings.get(2)),condition);
            state.instructionList.add(instruction);
        }

        int maxEntryOverall = 0;


        System.out.println("Registers:");
        for (Instruction instruction : state.instructionList) {
            applyInstruction(instruction, state);

            if(maxEntryOverall < maxRegistryValue(state).getValue().value){
                maxEntryOverall = maxRegistryValue(state).getValue().value;
            }
        }


        Map.Entry<String, Register> maxEntryAtEnd = maxRegistryValue(state);
        System.out.format("Maximum Registry at the end %n%s:%d %n",maxEntryAtEnd.getKey(), maxEntryAtEnd.getValue().value);
        System.out.println("Maximum Registry Overall: "+maxEntryOverall);
    }

    public static void applyInstruction(Instruction instruction, State s){
        Register targetRegister = s.registerMap.get(instruction.target);
        if(checkCondition(instruction.condition, s)){
            switch (instruction.operation){
                case "inc":
                    targetRegister.incrementValue(instruction.value);
                    break;
                case "dec":
                    targetRegister.decrementValue(instruction.value);
                    break;
            }
        }
    }

    public static boolean checkCondition(Condition c, State s){
        boolean check = false;
        Register targetRegister = s.registerMap.get(c.target);
        switch (c.comparison){
            case "==":
                if(targetRegister.value == c.value){check = true;}
                break;
            case "!=":
                if(targetRegister.value != c.value){check = true;}
                break;
            case ">":
                if(targetRegister.value > c.value){check = true;}
                break;
            case "<":
                if(targetRegister.value < c.value){check = true;}
                break;
            case ">=":
                if(targetRegister.value >= c.value){check = true;}
                break;
            case "<=":
                if(targetRegister.value <= c.value){check = true;}
                break;
        }

        return check;
    }

    public static Map.Entry<String, Register> maxRegistryValue(State s){

        Map.Entry<String, Register> maxEntry = null;
        for (Map.Entry<String, Register> entry : s.registerMap.entrySet()) {

            if(maxEntry == null || entry.getValue().value > maxEntry.getValue().value ){
                maxEntry = entry;
            }

        }

        return maxEntry;
    }
}
