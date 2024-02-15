package Birds;

import java.util.List;

// Bird interface
public interface Bird {
    String getBirdType();
    String getDefiningCharacteristic();
    boolean isExtinct();
    int getNumberOfWings();
    List<FoodOption> getPreferredFood();
}