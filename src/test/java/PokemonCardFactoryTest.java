import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonCardFactoryTest {

    private PokemonCardFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PokemonCardFactory();
    }

    @Test
    void factoryCreatesCardWithCorrectInformation() {
        PokemonCard card = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        assertEquals("Pikachu", card.getName());
        assertEquals(PokemonSet.BASE_SET, card.getSet());
        assertEquals(Rarity.COMMON, card.getRarity());
        assertEquals(Variant.NORMAL, card.getVariant());
        assertEquals(PokemonType.LIGHTNING, card.getType());
    }

    @Test
    void sameCardInformationReturnsSameInstance() {
        PokemonCard first = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        PokemonCard second = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        assertSame(first, second);
    }

    @Test
    void differentNamesReturnDifferentInstances() {
        PokemonCard pikachu = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        PokemonCard charmander = factory.getCard(
                "Charmander",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.FIRE
        );

        assertNotSame(pikachu, charmander);
    }

    @Test
    void differentSetsReturnDifferentInstances() {
        PokemonCard first = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        PokemonCard second = factory.getCard(
                "Pikachu",
                PokemonSet.JUNGLE,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        assertNotSame(first, second);
    }

    @Test
    void differentRaritiesReturnDifferentInstances() {
        PokemonCard common = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        PokemonCard rare = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.RARE,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        assertNotSame(common, rare);
    }

    @Test
    void differentVariantsReturnDifferentInstances() {
        PokemonCard normal = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        PokemonCard holo = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.HOLO,
                PokemonType.LIGHTNING
        );

        assertNotSame(normal, holo);
    }

    @Test
    void differentTypesReturnDifferentInstances() {
        PokemonCard lightning = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        PokemonCard colorless = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.COLORLESS
        );

        assertNotSame(lightning, colorless);
    }

    @Test
    void separateFactoriesStillCreateEqualCards() {
        PokemonCardFactory otherFactory = new PokemonCardFactory();

        PokemonCard first = factory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        PokemonCard second = otherFactory.getCard(
                "Pikachu",
                PokemonSet.BASE_SET,
                Rarity.COMMON,
                Variant.NORMAL,
                PokemonType.LIGHTNING
        );

        assertEquals(first, second);
    }

    @Test
    void nullNameThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> factory.getCard(
                        null,
                        PokemonSet.BASE_SET,
                        Rarity.COMMON,
                        Variant.NORMAL,
                        PokemonType.LIGHTNING
                )
        );
    }

    @Test
    void blankNameThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> factory.getCard(
                        "   ",
                        PokemonSet.BASE_SET,
                        Rarity.COMMON,
                        Variant.NORMAL,
                        PokemonType.LIGHTNING
                )
        );
    }

    @Test
    void nullSetThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> factory.getCard(
                        "Pikachu",
                        null,
                        Rarity.COMMON,
                        Variant.NORMAL,
                        PokemonType.LIGHTNING
                )
        );
    }
}