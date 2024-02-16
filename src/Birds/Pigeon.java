package Birds;

import java.util.List;
/**
 * Represents pigeons and doves, known for feeding their young "bird milk".
 */
public class Pigeon extends BaseBird{
    public Pigeon(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
    }
}
