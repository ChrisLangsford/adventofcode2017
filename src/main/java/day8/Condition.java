package day8;

public class Condition {
    public String target;
    public String comparison;
    public int value;

    public Condition(String target, String comparison, int value) {
        this.target = target;
        this.comparison = comparison;
        this.value = value;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getComparison() {
        return comparison;
    }

    public void setComparison(String comparison) {
        this.comparison = comparison;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
