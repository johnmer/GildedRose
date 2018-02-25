public class BrieItemType extends ItemType {
    protected void updateItemQuality(Item item) {
        increaseQuality(item);
    }

    protected void updateItemSellin(Item item) {
        item.setSellIn(item.getSellIn() - 1);

    }

    protected void updateExpiredItem(Item item) {
        increaseQuality(item);
    }
}
