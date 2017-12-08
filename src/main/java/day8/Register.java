package day8;

public class Register {
    public String id;
    public int value;

    public void incrementValue(int n){
        this.value +=n;
    }
    public void decrementValue(int n){
        this.value-=n;
    }

    public Register(String id, int value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
