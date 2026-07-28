import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradingCompanyTest {

    @Test
    void psaAcceptsValidGrades() {
        assertTrue(GradingCompany.PSA.isValidGrade(1));
        assertTrue(GradingCompany.PSA.isValidGrade(5));
        assertTrue(GradingCompany.PSA.isValidGrade(10));
    }

    @Test
    void psaRejectsInvalidGrades() {
        assertFalse(GradingCompany.PSA.isValidGrade(0));
        assertFalse(GradingCompany.PSA.isValidGrade(10.5));
        assertFalse(GradingCompany.PSA.isValidGrade(11));
    }

    @Test
    void beckettAcceptsHalfGrades() {
        assertTrue(GradingCompany.BECKETT.isValidGrade(9));
        assertTrue(GradingCompany.BECKETT.isValidGrade(9.5));
        assertTrue(GradingCompany.BECKETT.isValidGrade(10));
    }

    @Test
    void beckettRejectsInvalidGrades() {
        assertFalse(GradingCompany.BECKETT.isValidGrade(9.3));
        assertFalse(GradingCompany.BECKETT.isValidGrade(10.5));
        assertFalse(GradingCompany.BECKETT.isValidGrade(0));
    }

    @Test
    void tagAcceptsValidGrades() {
        assertTrue(GradingCompany.TAG.isValidGrade(1));
        assertTrue(GradingCompany.TAG.isValidGrade(500));
        assertTrue(GradingCompany.TAG.isValidGrade(1000));
    }

    @Test
    void tagRejectsInvalidGrades() {
        assertFalse(GradingCompany.TAG.isValidGrade(0));
        assertFalse(GradingCompany.TAG.isValidGrade(1001));
        assertFalse(GradingCompany.TAG.isValidGrade(99.5));
    }
}