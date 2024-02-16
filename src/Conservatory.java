import Birds.*;

import java.util.*;
/**
 * Represents a conservatory that houses different types of birds in aviaries.
 */
public class Conservatory {
    private Map<Integer, List<Bird>> aviaries;

    public Conservatory() {
        aviaries = new HashMap<>();
    }

    // Method to rescue and bring new birds into the conservatory
//    public void rescueBird(Bird bird, int aviaryNumber) {
//        if (!aviaries.containsKey(aviaryNumber)) {
//            aviaries.put(aviaryNumber, new ArrayList<>());
//        }
//        aviaries.get(aviaryNumber).add(bird);
//    }
    public void addAviary(int aviaryNumber) {
        if (aviaries.size() >= 20) {
            throw new IllegalStateException("Maximum number of aviaries (20) reached.");
        }
        aviaries.put(aviaryNumber, new ArrayList<>());
    }

    // Method to calculate food needs in each aviary based on bird preferences
    public Map<Integer, Map<FoodOption, Integer>> calculateFoodNeedsPerAviary() {
        Map<Integer, Map<FoodOption, Integer>> foodNeedsPerAviary = new HashMap<>();

        // Iterate over each aviary
        for (Map.Entry<Integer, List<Bird>> entry : aviaries.entrySet()) {
            int aviaryNumber = entry.getKey();
            List<Bird> birds = entry.getValue();

            // Initialize a map to store food needs for the current aviary
            Map<FoodOption, Integer> foodNeeds = new HashMap<>();

            // Iterate over each bird in the aviary
            for (Bird bird : birds) {
                // Get the preferred food options of the bird
                List<FoodOption> preferredFoodOptions = bird.getPreferredFood();

                // Increment the count of each preferred food option for the current bird
                for (FoodOption foodOption : preferredFoodOptions) {
                    foodNeeds.put(foodOption, foodNeeds.getOrDefault(foodOption, 0) + 1);
                }
            }

            // Add the calculated food needs for the current aviary to the map
            foodNeedsPerAviary.put(aviaryNumber, foodNeeds);
        }

        return foodNeedsPerAviary;
    }

    // Method to assign a bird to an aviary following specified criteria
    public void assignBirdToAviary(Bird bird, int aviaryNumber) {
        if(bird.isExtinct()){
            throw new IllegalArgumentException("No extinct birds can be added to an aviary");
        }
        if (aviaries.size() >= 20) {
            throw new IllegalStateException("Maximum number of aviaries (20) reached.");
        }
        if (!aviaries.containsKey(aviaryNumber)) {
            aviaries.put(aviaryNumber, new ArrayList<>());
        }
        List<Bird> aviary = aviaries.get(aviaryNumber);

        if (aviary.size() < 5 ) {
            boolean validPlacement = true;
            if (bird instanceof FlightlessBird || bird instanceof BirdsofPrey || bird instanceof Waterfowl) {
                for (Bird b : aviary) {
                    if (b instanceof FlightlessBird || b instanceof BirdsofPrey || b instanceof Waterfowl) {
                        validPlacement = false;
                        break;
                    }
                }
            }
            if (validPlacement) {
                aviary.add(bird);
            } else {
                System.out.println("Cannot mix flightless birds, birds of prey, or waterfowl with other bird types.");
            }
        } else {
            throw new IllegalStateException("Aviary is full.");
        }
    }

    // Method to look up which aviary a bird is in
    public String findBirdAviary(Bird bird) {
        for (Map.Entry<Integer, List<Bird>> entry : aviaries.entrySet()) {
            if (entry.getValue().contains(bird)) {
                return "Bird is in aviary number " + entry.getKey();
            }
        }
        return "Bird not found in any aviary.";
    }

    // Method to print a sign for a given aviary describing the birds it houses
    public String printAviarySign(int aviaryNumber) {
        StringBuilder sign = new StringBuilder();
        if (aviaries.containsKey(aviaryNumber)) {
            sign.append("Aviary ").append(aviaryNumber).append(":\n");

            List<Bird> birds = aviaries.get(aviaryNumber);
            for (Bird bird : birds) {
                sign.append("Type: ").append(bird.getBirdType()).append("\n")
                        .append("Defining Characteristic: ").append(bird.getDefiningCharacteristic()).append("\n")
                        .append("Number of Wings: ").append(bird.getNumberOfWings()).append("\n")
                        .append("Preferred Diet: ").append(bird.getPreferredFood()).append("\n")
                        .append("\n");
            }
        } else {
            sign.append("Aviary ").append(aviaryNumber).append(" does not exist.");
        }
        return sign.toString();
    }

    // Method to print a "map" listing all aviaries by location and the birds they house
    public String printAviaryMap() {
        StringBuilder map = new StringBuilder();
        for (Map.Entry<Integer, List<Bird>> entry : aviaries.entrySet()) {
            map.append("Aviary ").append(entry.getKey()).append(":\n");
            List<Bird> birds = entry.getValue();
            for (Bird bird : birds) {
                map.append(bird.getBirdType()).append("\n");
            }
            map.append("\n");
        }
        return map.toString();
    }

    // Method to print an index listing all birds in the conservatory in alphabetical order and their location
    public String printBirdIndex() {
        StringBuilder index = new StringBuilder();
        List<Bird> allBirds = new ArrayList<>();
        for (List<Bird> birds : aviaries.values()) {
            allBirds.addAll(birds);
        }
        allBirds.sort(Comparator.comparing(Bird::getBirdType));
        for (Bird bird : allBirds) {
            index.append("Bird: ").append(bird.getBirdType()).append(", Location: ");
            index.append(findBirdAviary(bird)).append("\n");
        }
        return index.toString();
    }

}
