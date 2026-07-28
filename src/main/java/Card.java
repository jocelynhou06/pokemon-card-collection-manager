/**
 * Represents a Pokemon card. It can be a regular Pokemon card or a Graded card
 */
public interface Card {
    String getName();
    PokemonSet getSet();
    Rarity getRarity();
    Variant getVariant();
    PokemonType getType();
    Series getSeries();
    String getDescription();
}