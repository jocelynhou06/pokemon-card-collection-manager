import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonCardTest {
    private PokemonCardFactory factory;
    private PokemonCard pikachu;

    @BeforeEach
    void setUp() {
        factory = new PokemonCardFactory();

        pikachu = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );
    }

    @Test
    void cardStoresCorrectName() {
        assertEquals("Pikachu", pikachu.getName());
    }

    @Test
    void cardStoresCorrectSet() {
        assertEquals(PokemonSet.BASE_SET, pikachu.getSet());
    }

    @Test
    void cardStoresCorrectRarity() {
        assertEquals(Rarity.COMMON, pikachu.getRarity());
    }

    @Test
    void cardStoresCorrectVariant() {
        assertEquals(Variant.NORMAL, pikachu.getVariant());
    }

    @Test
    void cardStoresCorrectType() {
        assertEquals(PokemonType.LIGHTNING, pikachu.getType());
    }

    @Test
    void cardReturnsSeriesFromSet() {
        assertEquals(Series.ORIGINAL, pikachu.getSeries());
    }

    @Test
    void equalCardsAreEqual() {
        PokemonCard sameCard = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        assertEquals(pikachu, sameCard);
    }

    @Test
    void differentCardsAreNotEqual() {
        PokemonCard charizard = factory.getCard(
                "Charizard",
                PokemonSet.BASE_SET,
                Rarity.RARE,
                Variant.HOLO,
                PokemonType.FIRE
        );

        assertNotEquals(pikachu, charizard);
    }

    @Test
    void equalCardsHaveSameHashCode() {
        PokemonCard sameCard = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        assertEquals(pikachu.hashCode(), sameCard.hashCode());
    }

    @Test
    void descriptionContainsCardInformation() {
        String description = pikachu.getDescription();

        assertTrue(description.contains("Pikachu"));
        assertTrue(description.contains("Base Set"));
        assertTrue(description.contains("COMMON"));
        assertTrue(description.contains("NORMAL"));
        assertTrue(description.contains("LIGHTNING"));
    }
}