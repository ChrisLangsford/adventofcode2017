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

    public String readFileIntoString(){
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(inputFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
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





}
