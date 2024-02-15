package Birds;

import java.util.List;

public class BirdsofPrey extends BaseBird{
    public BirdsofPrey(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
    }
}
