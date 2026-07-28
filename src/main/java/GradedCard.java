import java.util.Objects;

/**
 * Decorator the represents graded Pokemon cards.
 * Adds grading info to an existing card.
 */
public class GradedCard extends CardDecorator {
    private final GradingCompany gradingCompany;
    private final double grade;
    private final String certificationNumber;

    /**
     * Constructs a grading card by decorating existing card
     *
     * @param pCard the card being graded
     * @param pGradingCompany the grading company
     * @param pGrade the assigned grade
     * @param pCertificationNumber the certification number
     */
    public GradedCard(Card pCard, GradingCompany pGradingCompany, double pGrade, String pCertificationNumber) {
        super(pCard);

        Objects.requireNonNull(pGradingCompany, "Grading company cannot be null.");
        Objects.requireNonNull(pCertificationNumber, "Certification number cannot be null.");

        if (pCertificationNumber.isBlank()) {
            throw new IllegalArgumentException("Certification number cannot be blank.");
        }

        if (!pGradingCompany.isValidGrade(pGrade)) {
            throw new IllegalArgumentException("main.java.Card grade is invalid.");
        }

        gradingCompany = pGradingCompany;
        grade = pGrade;
        certificationNumber = pCertificationNumber;
    }

    public GradingCompany getGradingCompany() {
        return gradingCompany;
    }

    public double getGrade() {
        return grade;
    }

    public String getCertificationNumber() {
        return certificationNumber;
    }

    @Override
    protected String getAdditionalDetails() {
        return gradingCompany + " " + formatGrade() + " | Cert #: " + certificationNumber;
    }

    /**
     * Returns grade formatted without a decimal when the grade is a whole number
     *
     * @return formatted grade
     */
    private String formatGrade() {
        if (grade == Math.floor(grade)) {
            return Integer.toString((int) grade);
        }
        return Double.toString(grade);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof GradedCard)) {
            return false;
        }

        GradedCard other = (GradedCard) object;
        return Double.compare(grade, other.grade) == 0 && decoratedCard.equals(other.decoratedCard) && gradingCompany == other.gradingCompany && certificationNumber.equals(other.certificationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(decoratedCard, gradingCompany, grade, certificationNumber);
    }
}