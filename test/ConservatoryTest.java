import Birds.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ConservatoryTest {
    @Test
    public void testCalculateFoodNeedsPerAviary() {
        // Create a sample conservatory
        Conservatory conservatory = new Conservatory();
        Bird bird1 = new Parrot("Parrot", "Intelligent", false, 2, Arrays.asList(FoodOption.FRUIT, FoodOption.SEEDS), 50, "Hello, World!");
        Bird bird2 = new Pigeon("Dove", "Feeds young bird milk", false, 2, Arrays.asList(FoodOption.BERRIES, FoodOption.SEEDS));
        Bird bird3 = new Waterfowl("Duck", "Waterfowl", false, 2,Arrays.asList(FoodOption.INSECTS, FoodOption.FISH),"Lake");
        Bird bird4 = new Owl("Owl", "Owl", false, 2, Arrays.asList(FoodOption.FISH));

        // Assign birds to aviaries
        conservatory.assignBirdToAviary(bird1, 1);
        conservatory.assignBirdToAviary(bird2, 1);
        conservatory.assignBirdToAviary(bird3, 2);
        conservatory.assignBirdToAviary(bird4, 2);

        // Expected food needs per aviary
        Map<Integer, Map<FoodOption, Integer>> expectedFoodNeeds = new HashMap<>();
        Map<FoodOption, Integer> foodNeedsAviary1 = new HashMap<>();
        foodNeedsAviary1.put(FoodOption.FRUIT, 1);
        foodNeedsAviary1.put(FoodOption.SEEDS, 2);
        foodNeedsAviary1.put(FoodOption.BERRIES, 1);
        Map<FoodOption, Integer> foodNeedsAviary2 = new HashMap<>();
        foodNeedsAviary2.put(FoodOption.INSECTS, 1);
        foodNeedsAviary2.put(FoodOption.FISH, 2);
        expectedFoodNeeds.put(1, foodNeedsAviary1);
        expectedFoodNeeds.put(2, foodNeedsAviary2);

        // Calculate food needs
        Map<Integer, Map<FoodOption, Integer>> actualFoodNeeds = conservatory.calculateFoodNeedsPerAviary();

        // Assert that the calculated food needs match the expected values
        assertEquals(expectedFoodNeeds, actualFoodNeeds);
    }
    @Test
    public void testMixedAviary() {
        // Create a sample conservatory
        Conservatory conservatory = new Conservatory();
        Bird bird1 = new Waterfowl("Duck", "Waterfowl", false, 2, Arrays.asList(FoodOption.INSECTS, FoodOption.FISH), "Lake");
        Bird bird2 = new BirdsofPrey("Hawk", "Bird of prey", false, 2, Arrays.asList(FoodOption.OTHER_BIRDS));
        // Assign birds to aviaries
        conservatory.assignBirdToAviary(bird1, 1);
        conservatory.assignBirdToAviary(bird2, 1);
        // Verify that birds are assigned to the correct aviaries

        assertEquals("Bird is in aviary number 1", conservatory.findBirdAviary(bird1));
        assertEquals("Bird not found in any aviary.", conservatory.findBirdAviary(bird2));
    }

    @Test
    public void testPrintAviarySign() {
        // Create a sample conservatory
        Conservatory conservatory = new Conservatory();

        // Create some sample birds
        Bird bird1 = new Parrot("Parrot", "Intelligent", false, 2, Arrays.asList(FoodOption.FRUIT, FoodOption.SEEDS), 50, "Hello, World!");
        Bird bird2 = new Pigeon("Dove", "Feeds young bird milk", false, 2, Arrays.asList(FoodOption.BERRIES, FoodOption.SEEDS));

        // Assign birds to aviaries
        conservatory.assignBirdToAviary(bird1, 1);
        conservatory.assignBirdToAviary(bird2, 2);

        // Expected sign for aviary 1
        String expectedSignAviary1 = "Aviary 1:\n" +
                "Type: Parrot\n" +
                "Defining Characteristic: Intelligent\n" +
                "Number of Wings: 2\n" +
                "Preferred Diet: [FRUIT, SEEDS]\n\n";

        // Expected sign for aviary 2
        String expectedSignAviary2 = "Aviary 2:\n" +
                "Type: Dove\n" +
                "Defining Characteristic: Feeds young bird milk\n" +
                "Number of Wings: 2\n" +
                "Preferred Diet: [BERRIES, SEEDS]\n\n";

        // Verify the signs for each aviary
        assertEquals(expectedSignAviary1, conservatory.printAviarySign(1));
        assertEquals(expectedSignAviary2, conservatory.printAviarySign(2));
    }

    @Test
    public void testPrintAviaryMap() {
        // Create a sample conservatory
        Conservatory conservatory = new Conservatory();

        // Create some sample birds
        Bird bird1 = new Parrot("Parrot", "Intelligent", false, 2, Arrays.asList(FoodOption.FRUIT, FoodOption.SEEDS), 50, "Hello, World!");
        Bird bird2 = new Pigeon("Dove", "Feeds young bird milk", false, 2, Arrays.asList(FoodOption.BERRIES, FoodOption.SEEDS));

        // Assign birds to aviaries
        conservatory.assignBirdToAviary(bird1, 1);
        conservatory.assignBirdToAviary(bird2, 2);

        // Expected map of aviaries
        String expectedMap = "Aviary 1:\n" +
                "Parrot\n\n" +
                "Aviary 2:\n" +
                "Dove\n\n";

        // Verify the map of aviaries
        assertEquals(expectedMap, conservatory.printAviaryMap());
    }

    @Test
    public void testPrintBirdIndex() {
        // Create a sample conservatory
        Conservatory conservatory = new Conservatory();

        // Create some sample birds
        Bird bird1 = new Parrot("Parrot", "Intelligent", false, 2, Arrays.asList(FoodOption.FRUIT, FoodOption.SEEDS), 50, "Hello, World!");
        Bird bird2 = new Pigeon("Dove", "Feeds young bird milk", false, 2, Arrays.asList(FoodOption.BERRIES, FoodOption.SEEDS));
        Bird bird3 = new Waterfowl("Duck", "Waterfowl", false, 2,Arrays.asList(FoodOption.INSECTS, FoodOption.FISH),"Lake");

        // Assign birds to aviaries
        conservatory.assignBirdToAviary(bird1, 1);
        conservatory.assignBirdToAviary(bird2, 1);
        conservatory.assignBirdToAviary(bird3, 2);

        // Expected bird index
        String expectedIndex =
                "Bird: Dove, Location: Bird is in aviary number 1\n" +
                "Bird: Duck, Location: Bird is in aviary number 2\n" +
                "Bird: Parrot, Location: Bird is in aviary number 1\n"
                ;

        // Verify the bird index
        assertEquals(expectedIndex, conservatory.printBirdIndex());
    }

    @Test
    public void testMaxBirds() {
        // Create a sample conservatory
        Conservatory conservatory = new Conservatory();

        // Create some sample birds
        Bird bird1 = new Parrot("Parrot", "Intelligent", false, 2, Arrays.asList(FoodOption.FRUIT, FoodOption.SEEDS), 50, "Hello, World!");
        Bird bird2 = new Pigeon("Dove", "Feeds young bird milk", false, 2, Arrays.asList(FoodOption.BERRIES, FoodOption.SEEDS));
        // Add birds to aviary
        conservatory.assignBirdToAviary(bird1, 1);
        conservatory.assignBirdToAviary(bird1, 1);
        conservatory.assignBirdToAviary(bird1, 1);
        conservatory.assignBirdToAviary(bird2, 1);
        conservatory.assignBirdToAviary(bird2, 1);
        // Attempt to add the 6th bird to the same aviary and expect an error
        assertThrows(IllegalStateException.class, () -> {
            conservatory.assignBirdToAviary(bird2, 1);});
    }

    @Test
    public void testMaxAviaries() {
        Conservatory conservatory = new Conservatory();

        // Create 20 aviaries
        for (int i = 1; i <= 20; i++) {
            conservatory.addAviary(i);
        }

        // Attempt to create the 21st aviary and expect an error
        assertThrows(IllegalStateException.class, () -> {
            conservatory.addAviary(21);
        });
    }

    @Test
    public void testNoExtinctBirdsInAviary() {
        // Create a conservatory
        Conservatory conservatory = new Conservatory();

        // Create a sample extinct bird
        Bird extinctBird = new Owl("Extinct", "Extinct", true, 2, null);

        // Attempt to add the extinct bird to an aviary and expect an error
        assertThrows(IllegalArgumentException.class, () -> {
            conservatory.assignBirdToAviary(extinctBird, 1);
        });
    }
}

