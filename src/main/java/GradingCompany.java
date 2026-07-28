/**
 * Represents the grading companies tracked.
 * Different companies have their own grading scales
 */
public enum GradingCompany {
    /**
     * PSA grades cards using whole numbers from 1-10
     */
    PSA {
        @Override
        public boolean isValidGrade(double grade) {
            return grade >= 1
                    && grade <= 10
                    && grade == Math.floor(grade);
        }
    },

    /**
     * Beckett grades cards with 0.5 increments from 1-10
     */
    BECKETT {
        @Override
        public boolean isValidGrade(double grade) {
            return grade >= 1
                    && grade <= 10
                    && grade * 2 == Math.floor(grade * 2);
        }
    },

    /**
     * TAG grades cards using whole numbers from 1-1000
     */
    TAG {
        @Override
        public boolean isValidGrade(double grade) {
            return grade >= 1
                    && grade <= 1000
                    && grade == Math.floor(grade);
        }
    };

    /**
     * Determinnes if given grade is valid for corresponding grading company
     *
     * @param grade the grade to validate
     * @return true if grade is valid
     *         false if grade is false
     */
    public abstract boolean isValidGrade(double grade);
}