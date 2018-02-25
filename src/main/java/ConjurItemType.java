public class ConjurItemType extends ItemType {

    @Override
    public void updateItemQuality(Item item) {
        reduceQuality(item);
        reduceQuality(item);

    }

    @Override
    public void updateExpiredItem(Item item) {
        reduceQuality(item);
        reduceQuality(item);

    }
}
