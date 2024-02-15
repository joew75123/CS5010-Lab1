package Birds;

import java.util.List;

// Waterfowl class implementing the WaterBirdCharacteristics interface and extending BaseBird
public class Waterfowl extends BaseBird implements WaterBirdCharacteristics {
    private final String waterBody;
    public Waterfowl(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<String> preferFood, String waterBody) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
        this.waterBody = waterBody;
    }

    @Override
    public String getWaterBody() {
        return waterBody;
    }
}
