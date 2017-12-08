package day8;

public class Instruction {
    public String target;
    public String operation;
    public int value;
    public Condition condition;

    public Instruction(String target, String operation, int value, Condition condition) {
        this.target = target;
        this.operation = operation;
        this.value = value;
        this.condition = condition;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
