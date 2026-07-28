import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortBySetStrategyTest {

    private PokemonCardFactory factory;
    private SortBySetStrategy strategy;

    @BeforeEach
    void setUp() {
        factory = new PokemonCardFactory();
        strategy = new SortBySetStrategy();
    }

    @Test
    void cardsAreSortedBySet() {
        CollectionEntry jungle = new CollectionEntry(
                factory.getCard(
                        "Pikachu",
                        PokemonSet.JUNGLE,
                        Rarity.COMMON,
                        Variant.NORMAL,
                        PokemonType.LIGHTNING
                )
        );

        CollectionEntry baseSet = new CollectionEntry(
                factory.getCard(
                        "Pikachu",
                        PokemonSet.BASE_SET,
                        Rarity.COMMON,
                        Variant.NORMAL,
                        PokemonType.LIGHTNING
                )
        );

        List<CollectionEntry> cards = new ArrayList<>();
        cards.add(jungle);
        cards.add(baseSet);

        List<CollectionEntry> sortedCards = strategy.sort(cards);

        assertEquals(
                PokemonSet.BASE_SET,
                sortedCards.get(0).getCard().getSet()
        );

        assertEquals(
                PokemonSet.JUNGLE,
                sortedCards.get(1).getCard().getSet()
        );
    }

    @Test
    void cardsWithSameSetAreSortedByName() {
        CollectionEntry pikachu = new CollectionEntry(
                factory.getCard(
                        "Pikachu",
                        PokemonSet.BASE_SET,
                        Rarity.COMMON,
                        Variant.NORMAL,
                        PokemonType.LIGHTNING
                )
        );

        CollectionEntry bulbasaur = new CollectionEntry(
                factory.getCard(
                        "Bulbasaur",
                        PokemonSet.BASE_SET,
                        Rarity.COMMON,
                        Variant.NORMAL,
                        PokemonType.GRASS
                )
        );

        List<CollectionEntry> cards = new ArrayList<>();
        cards.add(pikachu);
        cards.add(bulbasaur);

        List<CollectionEntry> sortedCards = strategy.sort(cards);

        assertEquals(
                "Bulbasaur",
                sortedCards.get(0).getCard().getName()
        );

        assertEquals(
                "Pikachu",
                sortedCards.get(1).getCard().getName()
        );
    }

    @Test
    void emptyListReturnsEmptyList() {
        List<CollectionEntry> cards = new ArrayList<>();

        List<CollectionEntry> sortedCards = strategy.sort(cards);

        assertTrue(sortedCards.isEmpty());
    }

    @Test
    void singleCardListRemainsUnchanged() {
        CollectionEntry pikachu = new CollectionEntry(
                factory.getCard(
                        "Pikachu",
                        PokemonSet.BASE_SET,
                        Rarity.COMMON,
                        Variant.NORMAL,
                        PokemonType.LIGHTNING
                )
        );

        List<CollectionEntry> cards = new ArrayList<>();
        cards.add(pikachu);

        List<CollectionEntry> sortedCards = strategy.sort(cards);

        assertEquals(1, sortedCards.size());
        assertSame(pikachu, sortedCards.get(0));
    }
}