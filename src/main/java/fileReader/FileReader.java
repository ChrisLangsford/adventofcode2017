package fileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class FileReader {

    private String inputFileLocation;
    private File inputFile;
    private String defaultDelimiter;

    public FileReader(String inputFileLocation) {
        this.inputFileLocation = inputFileLocation;
        this.inputFile = initFile();
        this.defaultDelimiter = "";

    }

    private File initFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(inputFileLocation).getFile());
    }

    public List<Integer> readFileIntoIntegerArrayList(String delimiter){
        List<Integer> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(inputFile)) {
            scanner.useDelimiter(Pattern.compile(delimiter));
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

    public List<Integer> readFileIntoIntegerArrayList(){
        return readFileIntoIntegerArrayList(defaultDelimiter);
    }

    public List<Integer> readLinesIntoIntegerArrayList(){
        List<Integer> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(inputFile)) {

            while (scanner.hasNextLine()) {
                int num = Integer.parseInt(scanner.nextLine());
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

    public List<List<String>> readFileIntoListOfLines(){
        List<List<String>> result = new ArrayList<>();

        try (Scanner scanner = new Scanner(inputFile)){
            while(scanner.hasNextLine()){
                List<String> line = new ArrayList<>();
                for(String word : scanner.nextLine().split(" ")){
                    line.add(word);
                }
                result.add(line);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
        return  result;
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
