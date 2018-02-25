public class BrieItemType extends ItemType {

    @Override
    public void updateItemQuality(Item item) {
        increaseQuality(item);
    }

    @Override
    public void updateItemSellin(Item item) {
        item.setSellIn(item.getSellIn() - 1);

    }

    @Override
    public void updateExpiredItem(Item item) {
        increaseQuality(item);
    }
}
