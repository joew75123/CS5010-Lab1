import Birds.Bird;

import java.util.ArrayList;
import java.util.List;

public class Aviary {
    public static final int MAX_CAPACITY = 5;

    private String location;
    private List<Bird> birds;

    public Aviary(String location) {
        this.location = location;
        this.birds = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public int getNumBirds() {
        return birds.size();
    }

    public String getBirdType() {
        if (!birds.isEmpty()) {
            return birds.get(0).getBirdType();
        }
        return "Unknown";
    }

    public void addBird(Bird bird) {
        birds.add(bird);
    }
}