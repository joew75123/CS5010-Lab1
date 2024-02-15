package Birds;

import java.util.List;

public class Owl extends BaseBird{
    public Owl(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
    }
}
