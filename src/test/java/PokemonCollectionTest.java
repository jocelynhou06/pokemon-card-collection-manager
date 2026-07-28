import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PokemonCollectionTest {

    private PokemonCollection collection;
    private PokemonCardFactory factory;
    private PokemonCard pikachu;
    private PokemonCard charizard;

    @BeforeEach
    void setUp() {
        collection = new PokemonCollection();
        factory = new PokemonCardFactory();

        pikachu = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        charizard = factory.getCard(
                "Charizard",
                PokemonSet.BASE_SET,
                Rarity.RARE,
                Variant.HOLO,
                PokemonType.FIRE
        );
    }

    @Test
    void newCollectionDoesNotContainCard() {
        assertFalse(collection.contains(pikachu));
        assertEquals(0, collection.getQuantity(pikachu));
    }

    @Test
    void addingCardPlacesCardInCollection() {
        collection.addCard(pikachu);

        assertTrue(collection.contains(pikachu));
        assertEquals(1, collection.getQuantity(pikachu));
    }

    @Test
    void addingSameCardIncreasesQuantity() {
        collection.addCard(pikachu);
        collection.addCard(pikachu);
        collection.addCard(pikachu);

        assertTrue(collection.contains(pikachu));
        assertEquals(3, collection.getQuantity(pikachu));
    }

    @Test
    void addingDifferentCardsTracksEachQuantity() {
        collection.addCard(pikachu);
        collection.addCard(charizard);
        collection.addCard(charizard);

        assertEquals(1, collection.getQuantity(pikachu));
        assertEquals(2, collection.getQuantity(charizard));
    }

    @Test
    void removingCardDecreasesQuantity() {
        collection.addCard(pikachu);
        collection.addCard(pikachu);

        boolean removed = collection.removeCard(pikachu);

        assertTrue(removed);
        assertTrue(collection.contains(pikachu));
        assertEquals(1, collection.getQuantity(pikachu));
    }

    @Test
    void removingLastCopyRemovesCardFromCollection() {
        collection.addCard(pikachu);

        boolean removed = collection.removeCard(pikachu);

        assertTrue(removed);
        assertFalse(collection.contains(pikachu));
        assertEquals(0, collection.getQuantity(pikachu));
    }

    @Test
    void removingMissingCardReturnsFalse() {
        boolean removed = collection.removeCard(pikachu);

        assertFalse(removed);
        assertFalse(collection.contains(pikachu));
    }

    @Test
    void collectionCanStoreGradedCard() {
        GradedCard gradedPikachu = new GradedCard(
                pikachu,
                GradingCompany.PSA,
                10,
                "12345678"
        );

        collection.addCard(gradedPikachu);

        assertTrue(collection.contains(gradedPikachu));
        assertEquals(1, collection.getQuantity(gradedPikachu));
    }

    @Test
    void rawAndGradedCardsAreStoredSeparately() {
        GradedCard gradedPikachu = new GradedCard(
                pikachu,
                GradingCompany.PSA,
                10,
                "12345678"
        );

        collection.addCard(pikachu);
        collection.addCard(gradedPikachu);

        assertEquals(1, collection.getQuantity(pikachu));
        assertEquals(1, collection.getQuantity(gradedPikachu));
    }

    @Test
    void iteratorVisitsCardsInCollection() {
        collection.addCard(pikachu);
        collection.addCard(charizard);

        Iterator<Card> iterator = collection.iterator();

        assertTrue(iterator.hasNext());

        Card first = iterator.next();

        assertNotNull(first);
        assertTrue(first.equals(pikachu) || first.equals(charizard));
    }

    @Test
    void addingNullCardThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> collection.addCard(null)
        );
    }

    @Test
    void checkingNullCardThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> collection.contains(null)
        );
    }
}