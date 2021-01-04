import java.util.List;

public class Pet {
    private String name;
    private List<Integer> petPreferencelist;

    Pet(String name, List<Integer> petPreferencelist) {
        this.name = name;
        this.petPreferencelist = petPreferencelist;
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getPetPreferencelist() {
        return this.petPreferencelist;
    }
}
