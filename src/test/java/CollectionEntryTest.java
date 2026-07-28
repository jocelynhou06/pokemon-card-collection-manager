import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionEntryTest {
    private CollectionEntry entry;
    private PokemonCard card;

    @BeforeEach
    void setUp() {
        PokemonCardFactory factory = new PokemonCardFactory();

        card = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        entry = new CollectionEntry(card);
    }

    @Test
    void constructorStoresCard() {
        assertEquals(card, entry.getCard());
    }

    @Test
    void newEntryStartsWithQuantityOne() {
        assertEquals(1, entry.getQuantity());
    }

    @Test
    void increaseQuantityIncrementsCount() {
        entry.increaseQuantity();

        assertEquals(2, entry.getQuantity());
    }

    @Test
    void increaseQuantityMultipleTimes() {
        entry.increaseQuantity();
        entry.increaseQuantity();
        entry.increaseQuantity();

        assertEquals(4, entry.getQuantity());
    }

    @Test
    void decreaseQuantityReducesCount() {
        entry.increaseQuantity();
        entry.increaseQuantity();

        entry.decreaseQuantity();

        assertEquals(2, entry.getQuantity());
    }

    @Test
    void decreaseToZeroIsAllowed() {
        entry.decreaseQuantity();

        assertEquals(0, entry.getQuantity());
    }

    @Test
    void decreasingBelowZeroThrowsException() {
        entry.decreaseQuantity();

        assertThrows(
                IllegalStateException.class,
                () -> entry.decreaseQuantity()
        );
    }

    @Test
    void nullCardThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> new CollectionEntry(null)
        );
    }
}