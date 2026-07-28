import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradedCardTest {
    private PokemonCard baseCard;
    private PokemonCardFactory factory;

    @BeforeEach
    void setUp() {
        factory = new PokemonCardFactory();

        baseCard = factory.getCard(
                "Charizard",
                PokemonSet.BASE_SET,
                Rarity.RARE,
                Variant.HOLO,
                PokemonType.FIRE
        );
    }

    @Test
    void constructorStoresValues() {
        GradedCard graded = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "12345"
        );

        assertEquals(GradingCompany.PSA, graded.getGradingCompany());
        assertEquals(10, graded.getGrade());
        assertEquals("12345", graded.getCertificationNumber());
    }

    @Test
    void decoratedCardKeepsOriginalInformation() {
        GradedCard graded = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "12345"
        );

        assertEquals(baseCard.getName(), graded.getName());
        assertEquals(baseCard.getSet(), graded.getSet());
        assertEquals(baseCard.getRarity(), graded.getRarity());
        assertEquals(baseCard.getVariant(), graded.getVariant());
        assertEquals(baseCard.getType(), graded.getType());
        assertEquals(baseCard.getSeries(), graded.getSeries());
    }

    @Test
    void descriptionContainsGradingInformation() {
        GradedCard graded = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "12345"
        );

        String description = graded.getDescription();

        assertTrue(description.contains("PSA"));
        assertTrue(description.contains("10"));
        assertTrue(description.contains("12345"));
    }

    @Test
    void nullCardThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> new GradedCard(
                        null,
                        GradingCompany.PSA,
                        10,
                        "12345"
                )
        );
    }

    @Test
    void nullGradingCompanyThrowsException() {
        assertThrows(
                NullPointerException.class,
                () -> new GradedCard(
                        baseCard,
                        null,
                        10,
                        "12345"
                )
        );
    }

    @Test
    void blankCertificationNumberThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new GradedCard(
                        baseCard,
                        GradingCompany.PSA,
                        10,
                        ""
                )
        );
    }

    @Test
    void invalidGradeThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new GradedCard(
                        baseCard,
                        GradingCompany.PSA,
                        11,
                        "12345"
                )
        );
    }

    @Test
    void equalGradedCardsAreEqual() {
        GradedCard first = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "12345"
        );

        GradedCard second = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "12345"
        );

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void differentGradesAreNotEqual() {
        GradedCard first = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                9,
                "12345"
        );

        GradedCard second = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "12345"
        );

        assertNotEquals(first, second);
    }
}