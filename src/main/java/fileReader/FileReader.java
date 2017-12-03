package fileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileReader {

    private String inputFileLocation;
    private File inputFile;

    public FileReader(String inputFileLocation) {
        this.inputFileLocation = inputFileLocation;
        this.inputFile = initFile();
    }

    private File initFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(inputFileLocation).getFile());
    }

    public List<Integer> readFileIntoIntegerArrayList(){
        List<Integer> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(inputFile)) {
            scanner.useDelimiter("");
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                result.add(num);
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<List<Integer>> readfileIntoListofIntArrays(){
        List<List<Integer>> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(inputFile)) {

            while(scanner.hasNextLine()){
                String[] line = scanner.nextLine().split("\t");
                List<Integer> numbers = new ArrayList<>();
                for(String num : line){
                    numbers.add(Integer.parseInt(num));
                }
                result.add(numbers);
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int ReadSingleIntegerValueFromFile(){
        int result = 0;

        try (Scanner scanner = new Scanner(inputFile)) {
            result = scanner.nextInt();
            scanner.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
