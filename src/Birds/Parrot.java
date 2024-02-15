package Birds;

import java.util.List;

public class Parrot extends BaseBird implements ParrotCharacteristics {

    private final int vocabularySize;
    private final String favoriteSaying;
    public Parrot(String type, String definingCharacteristic, boolean extinct, int numberOfWings, List<FoodOption> preferFood, int vocabularySize, String favoriteSaying) {
        super(type, definingCharacteristic, extinct, numberOfWings, preferFood);
        this.vocabularySize = vocabularySize;
        this.favoriteSaying = favoriteSaying;
    }

    @Override
    public int getVocabularySize() {
        return vocabularySize;
    }

    @Override
    public String getFavoriteSaying() {
        return favoriteSaying;
    }
}
