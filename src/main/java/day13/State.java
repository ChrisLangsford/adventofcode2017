package day13;

import java.util.ArrayList;
import java.util.List;

public class State {

    public List<Layer> layerList = new ArrayList<>();

    public int playerPosition;

    public List<Layer> collisions = new ArrayList<>();

    public int picoseconds = 0;

    public List<Layer> getCollisions() {
        return collisions;
    }

    public void setCollisions(List<Layer> collisions) {
        this.collisions = collisions;
    }

    public State(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public List<Layer> getLayerList() {
        return layerList;
    }

    public void setLayerList(List<Layer> layerList) {
        this.layerList = layerList;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public void tick(){
        //1. move player - starts at (2) for first iteration
        if(this.picoseconds > 0){
            this.playerPosition++;
        }
        System.out.println("Player at position: "+ this.playerPosition);
        //2. detect player-scanner collisions
        for (Layer layer : layerList) {
            if(layer.id == playerPosition && layer.layerScanner.position == 0){
                collisions.add(layer);
            }
        }
        //3. move scanners
        for (Layer layer : layerList) {
            layer.changeScannerDirection();
            layer.layerScanner.moveScanner();
        }
        //4. increment picoseconds
        picoseconds++;
    }

    public int calculateSeverity() {
        int s=0;

        for (Layer collision : this.collisions) {
            s += (collision.id * collision.size);
        }

        return s;
    }
}
