import java.io.FileNotFoundException;
import java.util.*;

public class StableMatching {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader reader = new FileReader();
        reader.readfile();
        if (!reader.checkInput()) {
            //Initializing Data Strcutures
            PeopleInfo getPeopleInfoObject = new PeopleInfo(reader);
            HashMap<String, String> peopleMatchingsMap = getPeopleInfoObject.getPeopleMatchingsMap();
            HashMap<String, List<Integer>> peopleAndPreferenceListMap = getPeopleInfoObject.getPeopleAndPreferenceListMap();
            List<String> unmatchedPeopleNames = getPeopleInfoObject.getUnmatchedPeopleNamesList();
            PetInfo getPetInfoObject = new PetInfo(unmatchedPeopleNames, reader);
            HashMap<String, String> petMatchingsMap = getPetInfoObject.getPetMatchingsMap();
            HashMap<String, HashMap<String, Integer>> petAndPreferenceListMap = getPetInfoObject.getPetAndPreferenceListMap();
            List<String> petnames = getPetInfoObject.getPetNamesList();

            // Implementation of Gale Shapley Algorithm
            while (!unmatchedPeopleNames.isEmpty()) {
                String currentpeople = unmatchedPeopleNames.get(0);
                int prefered = peopleAndPreferenceListMap.get(currentpeople).get(0);
                String preferedPetName = petnames.get((prefered - 1));
                if (petMatchingsMap.get(preferedPetName) == null) {
                    peopleMatchingsMap.put(currentpeople, preferedPetName);
                    petMatchingsMap.put(preferedPetName, currentpeople);
                    unmatchedPeopleNames.remove(currentpeople);
                } else {
                    String previousmatched = petMatchingsMap.get(preferedPetName);
                    int currentPeoplePreferencenumber = petAndPreferenceListMap.get(preferedPetName).get(currentpeople);
                    int previousMatchedPeoplePreferencenumber = petAndPreferenceListMap.get(preferedPetName).get(previousmatched);
                    if (currentPeoplePreferencenumber < previousMatchedPeoplePreferencenumber) {
                        petMatchingsMap.put(preferedPetName, currentpeople);
                        peopleMatchingsMap.put(currentpeople, preferedPetName);
                        peopleMatchingsMap.put(previousmatched, null);
                        unmatchedPeopleNames.remove(0);
                        unmatchedPeopleNames.add(0, previousmatched);
                        List<Integer> tempHolder = peopleAndPreferenceListMap.get(previousmatched);
                        tempHolder.remove(0);
                        peopleAndPreferenceListMap.put(previousmatched, tempHolder);
                    } else {
                        List<Integer> tempHolder = peopleAndPreferenceListMap.get(currentpeople);
                        tempHolder.remove(0);
                        peopleAndPreferenceListMap.put(currentpeople, tempHolder);
                    }
                }
            }
            for (String n : getPeopleInfoObject.getUnmatchedPeopleNamesList()) {
                String val = peopleMatchingsMap.get(n);
                System.out.println(n + " / " + val);
            }
        } else {
            System.out.println("Input File Empty");
        }
    }
}
