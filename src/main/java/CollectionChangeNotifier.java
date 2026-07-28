/**
 * Concrete observer that prints message whenever card is added/removed
 */
 class CollectionChangeNotifier implements CardObserver {

    @Override
    public void cardAdded(Card card) {
        System.out.println("main.java.Card added: " + card.getDescription());
    }

    @Override
    public void cardRemoved(Card card) {
        System.out.println("main.java.Card removed: " + card.getDescription());
    }
}