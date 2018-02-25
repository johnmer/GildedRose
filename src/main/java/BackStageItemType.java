public class BackStageItemType extends ItemType {

    @Override
    public void updateItemQuality(Item item) {
        increaseQuality(item);
        if (item.getSellIn() <= 10) {
            increaseQuality(item);
        }
        if (item.getSellIn() <= 5) {
            increaseQuality(item);
        }
    }

    @Override
    public void updateExpiredItem(Item item) {
            item.setQuality(0);
    }

}
