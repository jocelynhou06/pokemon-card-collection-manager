import java.util.Objects;

/**
 * Abstract decorator for cards.Uses Decorator pattern.
 * Wraps existing card and allows subclasses to add new features without changing the OG card.
 */
public abstract class CardDecorator extends AbstractCard {
    protected final Card decoratedCard;

    /**
     * Constructs decorator that wraps card
     *
     * @param pCard the card to be decorated
     */
    public CardDecorator(Card pCard) {
        Objects.requireNonNull(pCard, "main.java.Card cannot be null.");
        decoratedCard = pCard;
    }

    @Override
    public String getName() {
        return decoratedCard.getName();
    }

    @Override
    public PokemonSet getSet() {
        return decoratedCard.getSet();
    }

    @Override
    public Rarity getRarity() {
        return decoratedCard.getRarity();
    }

    @Override
    public Variant getVariant() {
        return decoratedCard.getVariant();
    }

    @Override
    public PokemonType getType() {
        return decoratedCard.getType();
    }

    @Override
    public Series getSeries() {
        return decoratedCard.getSeries();
    }
}