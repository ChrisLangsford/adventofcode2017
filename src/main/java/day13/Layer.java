package day13;

public class Layer {
    public int id;
    public int depth;
    public int size;
    public LayerScanner layerScanner;

    public Layer(int id, int depth) {
        this.id = id;
        this.depth = depth;
        this.layerScanner = new LayerScanner(0,"D");
        this.size = this.depth+1;
    }

    public void changeScannerDirection(){
        if(this.layerScanner.position == this.depth){
            this.layerScanner.direction = "U";
        }
        if(this.layerScanner.position == 0){
            this.layerScanner.direction = "D";
        }
    }
}
