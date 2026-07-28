import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardComparisonHelperTest {
    private PokemonCardFactory factory;
    private PokemonCard baseCard;

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
    void twoRawCardsCompareAsEqual() {

        PokemonCard second = factory.getCard(
                "Blastoise",
                PokemonSet.BASE_SET,
                Rarity.RARE,
                Variant.HOLO,
                PokemonType.WATER
        );

        assertEquals(
                0,
                CardComparisonHelper.compareGrades(baseCard, second)
        );
    }

    @Test
    void gradedCardComesBeforeRawCard() {

        GradedCard graded = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "12345"
        );

        assertTrue(
                CardComparisonHelper.compareGrades(graded, baseCard) < 0
        );
    }

    @Test
    void rawCardComesAfterGradedCard() {

        GradedCard graded = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "12345"
        );

        assertTrue(
                CardComparisonHelper.compareGrades(baseCard, graded) > 0
        );
    }

    @Test
    void higherGradeComesBeforeLowerGrade() {

        GradedCard psa10 = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "11111"
        );

        GradedCard psa9 = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                9,
                "22222"
        );

        assertTrue(
                CardComparisonHelper.compareGrades(psa10, psa9) < 0
        );
    }

    @Test
    void equalGradesCompareAsEqual() {

        GradedCard first = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "11111"
        );

        GradedCard second = new GradedCard(
                baseCard,
                GradingCompany.PSA,
                10,
                "22222"
        );

        assertEquals(
                0,
                CardComparisonHelper.compareGrades(first, second)
        );
    }
}