package Birds;

import java.util.List;

// Base class implementing the Bird interface
public class BaseBird implements Bird {
    private final String type;
    private final String definingCharacteristic;
    private final boolean extinct;
    private final int numberOfWings;
    private final List<FoodOption> preferFood;


    public BaseBird(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood) {
        this.type = type;
        this.definingCharacteristic = definingCharacteristic;
        this.extinct = extinct;
        this.numberOfWings = numberOfWings;
        this.preferFood = preferFood;
    }

    @Override
    public String getBirdType() {
        return type;
    }

    @Override
    public String getDefiningCharacteristic() {
        return definingCharacteristic;
    }

    @Override
    public boolean isExtinct() {
        return extinct;
    }

    @Override
    public int getNumberOfWings() {
        return numberOfWings;
    }

    @Override
    public List<FoodOption> getPreferredFood() {
        return preferFood;
    }
}