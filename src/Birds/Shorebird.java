package Birds;

import java.util.List;

public class Shorebird extends BaseBird implements WaterBirdCharacteristics{

    private final String waterBody;
    public Shorebird(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood, String waterBody) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
        this.waterBody=waterBody;
    }

    @Override
    public String getWaterBody() {
        return waterBody;
    }
}
