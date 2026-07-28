import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Factory that creates and manages shared Pokemon main.java.Card flyweights.
 * If card with the same properites already exists, the existing instance is returned instead of creating new one
 */
public class PokemonCardFactory {
    /**
     * Stores shared Pokemon card flyweightts indexed by unique key
     */
    private final Map<String, PokemonCard> aCards;

    /**
     * Construct empty Pokemon card factory
     */
    public PokemonCardFactory() {
        aCards = new HashMap<>();
    }

    /**
     * Returns a shared Pokemon card with specified properties
     * If identical card has been already created, existing instance is returned
     *
     * @param pName the card's name
     * @param pSet the card's set
     * @param pRarity the card's rarity
     * @param pVariant the card's variant
     * @param pType the card's type
     * @return shared Pokemon card
     */
    public PokemonCard getCard(String pName, PokemonSet pSet, Rarity pRarity, Variant pVariant, PokemonType pType) {
        Objects.requireNonNull(pName, "Name cannot be null.");
        Objects.requireNonNull(pSet, "Set cannot be null.");
        Objects.requireNonNull(pRarity, "main.java.Rarity cannot be null.");
        Objects.requireNonNull(pVariant, "main.java.Variant cannot be null.");
        Objects.requireNonNull(pType, "Type cannot be null.");

        String key = createKey(pName, pSet, pRarity, pVariant, pType);

        if (!aCards.containsKey(key)) {
            PokemonCard card = new PokemonCard(pName, pSet, pRarity, pVariant, pType);
            aCards.put(key, card);
        }

        return aCards.get(key);
    }

    private String createKey(String pName, PokemonSet pSet, Rarity pRarity, Variant pVariant, PokemonType pType) {
        return pName + "|" + pSet.name() + "|" + pRarity.name() + "|" + pVariant.name() + "|" + pType.name();
    }

    /**
     * Returns number of unique flyweight objects manage by this factory
     * @return the number of shared Pokemon cards
     */
    public int getFlyweightCount() {
        return aCards.size();
    }
}