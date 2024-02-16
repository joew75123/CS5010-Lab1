package Birds;

import java.util.List;
/**
 * Represents owls, distinguished by their facial disks.
 */
public class Owl extends BaseBird{
    public Owl(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
    }
}
