import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortByNameStrategyTest {
    private PokemonCardFactory factory;
    private SortByNameStrategy strategy;

    @BeforeEach
    void setUp() {
        factory = new PokemonCardFactory();
        strategy = new SortByNameStrategy();
    }

    @Test
    void cardsAreSortedAlphabetically() {
        CollectionEntry charizard = new CollectionEntry(
                factory.getCard("Charizard", PokemonSet.BASE_SET,
                        Rarity.RARE, Variant.HOLO, PokemonType.FIRE));

        CollectionEntry bulbasaur = new CollectionEntry(
                factory.getCard("Bulbasaur", PokemonSet.BASE_SET,
                        Rarity.COMMON, Variant.NORMAL, PokemonType.GRASS));

        CollectionEntry pikachu = new CollectionEntry(
                factory.getCard("Pikachu", PokemonSet.BASE_SET,
                        Rarity.COMMON, Variant.NORMAL, PokemonType.LIGHTNING));

        List<CollectionEntry> cards = new ArrayList<>();
        cards.add(pikachu);
        cards.add(charizard);
        cards.add(bulbasaur);

        List<CollectionEntry> sortedCards = strategy.sort(cards);

        assertEquals("Bulbasaur", sortedCards.get(0).getCard().getName());
        assertEquals("Charizard", sortedCards.get(1).getCard().getName());
        assertEquals("Pikachu", sortedCards.get(2).getCard().getName());
    }

    @Test
    void emptyListRemainsEmpty() {
        List<CollectionEntry> cards = new ArrayList<>();

        strategy.sort(cards);

        assertTrue(cards.isEmpty());
    }

    @Test
    void singleCardListRemainsUnchanged() {
        CollectionEntry pikachu = new CollectionEntry(
                factory.getCard("Pikachu", PokemonSet.BASE_SET,
                        Rarity.COMMON, Variant.NORMAL, PokemonType.LIGHTNING));

        List<CollectionEntry> cards = new ArrayList<>();
        cards.add(pikachu);

        strategy.sort(cards);

        assertEquals("Pikachu", cards.get(0).getCard().getName());
    }
}