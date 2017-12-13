package day13;

import fileReader.FileReader;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

import static java.lang.System.exit;

@SpringBootApplication
public class PacketScanners implements CommandLineRunner {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(PacketScanners.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String...args) throws Exception {
        List<List<Integer>> input = new FileReader("input/day13.txt").readfileIntoListofIntArrays();
        State state = new State(0);

        int maxLayerId =0;
        for (List<Integer> integers : input) {
            if (integers.get(0) > maxLayerId){
                maxLayerId = integers.get(0);
            }
        }
        System.out.println(maxLayerId);

        int j=0;
        for (int i = 0; i <= maxLayerId; i++) {
            if (input.get(j).get(0) != i){
                state.layerList.add(new Layer(i,0));

            } else {
                state.layerList.add(new Layer(input.get(j).get(0), input.get(j).get(1)-1));
                j++;
            }
        }

        while(state.playerPosition < maxLayerId){
            state.tick();
        }

        int part1 = state.calculateSeverity();

        System.out.println("Severity: "+part1);

        exit(0);
    }
}
