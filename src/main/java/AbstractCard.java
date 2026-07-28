/**
 * Abstract implementation of main.java.Card that provides template for generating card descriptions
 * Sub classes can append additional information by overriding getAdditionalDetails
 */
public abstract class AbstractCard implements Card {
    /**
     * Returns formatted card description. Uses Template Method Pattern
     *
     * @return formatted description of card
     */
    @Override
    public final String getDescription() {
        String description = getName() + " | " + getSet().getDisplayName() + " | " + getRarity() + " | " + getVariant() + " | " + getType();
        String additionalDetails = getAdditionalDetails();

        if (!additionalDetails.isBlank()) {
            description += " | " + additionalDetails;
        }

        return description;
    }

    /**
     * Returns subclass specific details. Default is empty string
     *
     * @return extra description details or empty string
     */
    protected String getAdditionalDetails() {
        return "";
    }

    @Override
    public final String toString() {
        return getDescription();
    }
}
