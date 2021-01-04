import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    List<String> inputAsListofStrings = new ArrayList<String>();
    private List<People> peopleList = new ArrayList<>();
    private List<Pet> petList = new ArrayList<>();


    public void readfile() throws FileNotFoundException {
        //Reads input file and stores it in a List of String
        File file = new File("program1data.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            inputAsListofStrings.add(scan.nextLine());
        }
    }

    public boolean checkInput() {
        //Checks for an empty Input File
        if (inputAsListofStrings.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public List<People> initializePeopleObjectList() {
        // Extract names and peoplePreferenceList from the inputAsListofStrings and store it as an array of People
        int number = Integer.parseInt(inputAsListofStrings.get(0));
        for (int i = 1; i <= number; i++) {
            List<Integer> tempPeoplePreferenceList = new ArrayList<>();
            String temp = inputAsListofStrings.get(i + number);
            String[] temp_array = temp.split(" ");
            for (int j = 0; j < temp_array.length; j++) {
                tempPeoplePreferenceList.add(Integer.parseInt(temp_array[j]));
            }
            peopleList.add(new People(inputAsListofStrings.get(i), tempPeoplePreferenceList));
        }
        return peopleList;
    }

    public List<Pet> initializePetObjectList() {
        // Extract names and petPreferenceList from inputAsListofStrings and store it as an array of Pets
        int number = Integer.parseInt(inputAsListofStrings.get(0));
        int start = ((2 * number) + 1);
        int end = (3 * number);
        for (int i = start; i <= end; i++) {
            List<Integer> tempPetPreferenceList = new ArrayList<>();
            String temp = inputAsListofStrings.get(i + number);
            String[] temp_array = temp.split(" ");
            for (int j = 0; j < temp_array.length; j++) {
                tempPetPreferenceList.add(Integer.parseInt(temp_array[j]));
            }
            petList.add(new Pet(inputAsListofStrings.get(i), tempPetPreferenceList));
        }
        return petList;
    }
}
