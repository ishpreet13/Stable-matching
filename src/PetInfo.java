import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PetInfo {
    List<Pet> petObjectList;
    List<String> unmatchedPeopleNames;

    public PetInfo(List<String> unmatchedPeopleNames, FileReader reader) throws FileNotFoundException {
        this.unmatchedPeopleNames = unmatchedPeopleNames;
        this.petObjectList = reader.initializePetObjectList();
    }

    private HashMap<String, String> petMatchingsMap = new HashMap<>();
    private HashMap<String, HashMap<String, Integer>> petAndPreferenceListMap = new HashMap<>();
    private List<String> petnames = new ArrayList<>();

    public HashMap<String, String> getPetMatchingsMap() {
        // Creates an Empty pet matchings map
        Iterator itr = petObjectList.iterator();
        while (itr.hasNext()) {
            Pet p = (Pet) itr.next();
            petMatchingsMap.put(p.getName(), null);
        }
        return petMatchingsMap;
    }

    public HashMap<String, HashMap<String, Integer>> getPetAndPreferenceListMap() {
        //Create a pet and their preference list map
        Iterator itr = petObjectList.iterator();
        while (itr.hasNext()) {
            Pet p = (Pet) itr.next();
            List<Integer> petPreferenceTempListHolder = new ArrayList<>(p.getPetPreferencelist());
            HashMap<String, Integer> innerPetPreferenceMap = new HashMap<>();
            int preference = 1;
            for (Integer i : petPreferenceTempListHolder) {
                String name = unmatchedPeopleNames.get(i - 1);
                innerPetPreferenceMap.put(name, preference);
                preference++;
            }
            petAndPreferenceListMap.put(p.getName(), innerPetPreferenceMap);
        }
        return petAndPreferenceListMap;
    }

    public List<String> getPetNamesList() {
        //Creates a pet names list
        Iterator itr = petObjectList.iterator();
        while (itr.hasNext()) {
            Pet p = (Pet) itr.next();
            petnames.add(p.getName());
        }
        return petnames;
    }

}
