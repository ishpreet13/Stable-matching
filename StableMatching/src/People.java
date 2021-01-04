import java.util.List;

public class People {
    private String name;
    private List<Integer> peoplePreferencelist;

    public People(String name, List<Integer> peoplePreferencelist) {
        this.name = name;
        this.peoplePreferencelist = peoplePreferencelist;
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getPeoplePreferencelist() {
        return this.peoplePreferencelist;
    }
}
