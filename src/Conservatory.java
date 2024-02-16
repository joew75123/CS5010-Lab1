import Birds.Bird;
import Birds.FoodOption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conservatory {
    private static final int MAX_AVIARIES = 20;

    private List<Aviary> aviaries;
    private Map<Bird, Aviary> birdAviaryMap;

    public Conservatory() {
        this.aviaries = new ArrayList<>();
        this.birdAviaryMap = new HashMap<>();
    }

    // Method to rescue a new bird and bring it into the conservatory
    public void rescueBird(Bird bird) {
        if (birdAviaryMap.containsKey(bird)) {
            throw new IllegalArgumentException("Bird is already in the conservatory");
        }
        if (aviaries.size() >= MAX_AVIARIES) {
            throw new IllegalStateException("Maximum number of aviaries reached");
        }
        for (Aviary aviary : aviaries) {
            if (aviary.getNumBirds() < Aviary.MAX_CAPACITY) {
                aviary.addBird(bird);
                birdAviaryMap.put(bird, aviary);
                return;
            }
        }
        // If no available aviary, create a new one
        Aviary newAviary = new Aviary("Aviary " + (aviaries.size() + 1));
        aviaries.add(newAviary);
        newAviary.addBird(bird);
        birdAviaryMap.put(bird, newAviary);
    }
    // Method to calculate what food needs to be kept and in what quantities
    public Map<FoodOption, Integer> calculateFoodRequirements() {
        Map<FoodOption, Integer> foodRequirements = new HashMap<>();
        for (Bird bird : birdAviaryMap.keySet()) {
            List<FoodOption> preferredFood = bird.getPreferredFood();
            for (FoodOption food : preferredFood) {
                foodRequirements.put(food, foodRequirements.getOrDefault(food, 0) + 1);
            }
        }
        return foodRequirements;
    }

    // Method to assign a bird to an aviary in the conservatory
    public void assignBirdToAviary(Bird bird, Aviary aviary) {
        if (bird.isExtinct()) {
            throw new IllegalArgumentException("Extinct birds cannot be added to an aviary");
        }
        if (birdAviaryMap.containsKey(bird)) {
            throw new IllegalArgumentException("Bird is already assigned to an aviary");
        }
        if (aviary.getNumBirds() >= Aviary.MAX_CAPACITY) {
            throw new IllegalStateException("Aviary is at maximum capacity");
        }

        if (!bird.getBirdType().equals(aviary.getBirdType())) {
            throw new IllegalArgumentException("Incompatible bird type for the aviary");
        }

        aviary.addBird(bird);
        birdAviaryMap.put(bird, aviary);
    }

    // Method to look up which aviary a bird is in
    public String findAviaryForBird(Bird bird) {
        Aviary aviary = birdAviaryMap.get(bird);
        return (aviary != null) ? aviary.getLocation() : "Bird is not in any aviary";
    }

    // Method to print a sign for a given aviary
    public String printAviarySign(Aviary aviary) {
        StringBuilder sign = new StringBuilder();
        sign.append("Aviary Location: ").append(aviary.getLocation()).append("\n");
        sign.append("Description of Birds:\n");
        for (Bird bird : aviary.getBirds()) {
            sign.append("- ").append(bird.getBirdType()).append(": ").append(bird.getDefiningCharacteristic()).append("\n");
        }
        return sign.toString();
    }

    // Method to print a "map" listing all aviaries by location and the birds they house
    public String printAviaryMap() {
        StringBuilder map = new StringBuilder();
        map.append("Aviary Map:\n");
        for (Aviary aviary : aviaries) {
            map.append("- Location: ").append(aviary.getLocation()).append("\n");
            map.append("  Birds Housed:\n");
            for (Bird bird : aviary.getBirds()) {
                map.append("  - ").append(bird.getBirdType()).append("\n");
            }
        }
        return map.toString();
    }

    // Method to print an index listing all birds in the conservatory in alphabetical order and their location
    public String printBirdIndex() {
        StringBuilder index = new StringBuilder();
        index.append("Bird Index:\n");
        for (Bird bird : birdAviaryMap.keySet()) {
            index.append("- ").append(bird.getBirdType()).append(": ").append(findAviaryForBird(bird)).append("\n");
        }
        return index.toString();
    }
}