import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PeopleInfo {

    List<People> peopleObjectList;

    public PeopleInfo(FileReader reader) throws FileNotFoundException {
        this.peopleObjectList = reader.initializePeopleObjectList();
    }

    private HashMap<String, String> peopleMatchingsMap = new HashMap<>();
    private HashMap<String, List<Integer>> peopleAndPreferenceListMap = new HashMap<>();
    private List<String> unmatchedPeopleNames = new ArrayList<>();

    public HashMap<String, String> getPeopleMatchingsMap() {
        //Creates an Empty people matchings map
        Iterator iterator = peopleObjectList.iterator();
        while (iterator.hasNext()) {
            People p = (People) iterator.next();
            peopleMatchingsMap.put(p.getName(), null);
        }
        return peopleMatchingsMap;
    }

    public HashMap<String, List<Integer>> getPeopleAndPreferenceListMap() {
        //Creates  a people and their preference list map
        Iterator iterator = peopleObjectList.iterator();
        while (iterator.hasNext()) {
            People p = (People) iterator.next();
            peopleAndPreferenceListMap.put(p.getName(), p.getPeoplePreferencelist());
        }
        return peopleAndPreferenceListMap;
    }

    public List<String> getUnmatchedPeopleNamesList() {
        //Creates an unmatched people list
        Iterator iterator = peopleObjectList.iterator();
        while (iterator.hasNext()) {
            People p = (People) iterator.next();
            unmatchedPeopleNames.add(p.getName());
        }
        return unmatchedPeopleNames;
    }
}
