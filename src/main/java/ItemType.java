public class ItemType {
    public static ItemType determineItemType(Item item) {
        if (item.getName().equals("Sulfuras, Hand of Ragnaros"))
            return new SulfuraItemType();
        if (item.getName().equals("Aged Brie"))
            return new BrieItemType();
        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert"))
            return new BackStageItemType();
        if (item.getName().equals("Conjured Mana Cake"))
            return new ConjurItemType();
        return new StandardItemType();
    }

    protected void updateItem(Item item) {
        updateItemQuality(item);
        updateItemSellin(item);
        if (item.getSellIn() < 0) {
            updateExpiredItem(item);
        }
    }

    protected void updateItemQuality(Item item) {
        reduceQuality(item);
    }

    protected void updateItemSellin(Item item) {
        item.setSellIn(item.getSellIn() - 1);
    }

    protected void updateExpiredItem(Item item) {
        reduceQuality(item);
    }

    public void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    public void reduceQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }
}
