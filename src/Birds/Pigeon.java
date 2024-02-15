package Birds;

import java.util.List;

public class Pigeon extends BaseBird{
    public Pigeon(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
    }
}
