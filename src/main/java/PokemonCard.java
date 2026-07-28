import java.util.Objects;

/**
 * Represents Pokemon card with its properties.
 * Serves as Flyweight object shared byu multiple collections and decorators.
 */
public class PokemonCard extends AbstractCard {
    private final String aName;
    private final PokemonSet aSet;
    private final Rarity aRarity;
    private final Variant aVariant;
    private final PokemonType aType;

    /**
     * Construct Pokemon card with specified properties
     * @param pName the card's name
     * @param pSet the card's set
     * @param pRarity the card's rarity
     * @param pVariant the card's variant
     * @param pType the card's type
     */
    PokemonCard(String pName, PokemonSet pSet, Rarity pRarity, Variant pVariant, PokemonType pType) {
        aName = Objects.requireNonNull(pName, "Name cannot be null.");
        aSet = Objects.requireNonNull(pSet, "Set cannot be null.");
        aRarity = Objects.requireNonNull(pRarity, "main.java.Rarity cannot be null.");
        aVariant = Objects.requireNonNull(pVariant, "main.java.Variant cannot be null.");
        aType = Objects.requireNonNull(pType, "Type cannot be null.");
    }

    @Override
    public String getName() {
        return aName;
    }

    @Override
    public PokemonSet getSet() {
        return aSet;
    }

    @Override
    public Rarity getRarity() {
        return aRarity;
    }

    @Override
    public Variant getVariant() {
        return aVariant;
    }

    @Override
    public PokemonType getType() {
        return aType;
    }

    @Override
    public Series getSeries() {
        return aSet.getSeries();
    }

    @Override
    public boolean equals(Object pObject) {
        if (this == pObject) {
            return true;
        }

        if (!(pObject instanceof PokemonCard)) {
            return false;
        }

        PokemonCard other = (PokemonCard) pObject;
        return aName.equals(other.aName) && aSet == other.aSet  && aRarity == other.aRarity && aVariant == other.aVariant && aType == other.aType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aName, aSet, aRarity, aVariant, aType);
    }
}
