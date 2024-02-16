package Birds;

import java.util.List;

/**
 * Represents waterfowl living near water sources such as ducks, swans, and geese.
 */
public class Waterfowl extends BaseBird implements WaterBirdCharacteristics {
    private final String waterBody;
    public Waterfowl(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood, String waterBody) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
        this.waterBody = waterBody;
    }

    @Override
    public String getWaterBody() {
        return waterBody;
    }
}
