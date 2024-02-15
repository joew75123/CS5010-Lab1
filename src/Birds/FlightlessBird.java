package Birds;

import java.util.List;

public class FlightlessBird extends BaseBird {

    public FlightlessBird(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
        numberOfWings=0;
    }
}
