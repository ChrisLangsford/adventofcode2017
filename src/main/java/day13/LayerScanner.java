package day13;

public class LayerScanner {
    public int position;
    public String direction;

    public void moveScanner(){

        if(this.direction.equals("D")){
            this.position++;
        }else {
            this.position--;
        }
    }

    public LayerScanner(int position, String direction) {
        this.position = position;
        this.direction = direction;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
