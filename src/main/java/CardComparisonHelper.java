/**
 * Class that has helper method for comparing cards
 */
public final class CardComparisonHelper {
    /**
     * Prevents class from being instantiated
     */
    private CardComparisonHelper() {

    }

    /**
     * Compares cards based on their graded information.
     * Graded cards ordered before ungraded cards, and higher grades are ordered before lower grades.
     *
     * @param firstCard the 1st card to compare
     * @param secondCard the 2nd card to compare
     * @return negative int if 1st card should come first
     *         positive int if 2nd card should come first
     *         zero if cards are equal
     */
    public static int compareGrades(Card firstCard, Card secondCard) {
        boolean firstIsGraded = firstCard instanceof GradedCard;
        boolean secondIsGraded = secondCard instanceof GradedCard;

        if (firstIsGraded && secondIsGraded) {
            GradedCard firstGradedCard = (GradedCard) firstCard;
            GradedCard secondGradedCard = (GradedCard) secondCard;

            return Double.compare(
                    secondGradedCard.getGrade(),
                    firstGradedCard.getGrade()
            );
        }

        if (firstIsGraded) {
            return -1;
        }

        if (secondIsGraded) {
            return 1;
        }

        return 0;
    }
}