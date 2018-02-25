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
        if (("Aged Brie".equals(item.getName())) || "Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            updateSpecialItems(item);
        } else {
            reduceQuality(item);

            if ("Conjured Mana Cake".equals(item.getName())) {
                reduceQuality(item);
            }
        }
    }

    protected void updateSpecialItems(Item item) {
        increaseQuality(item);
        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            if (item.getSellIn() <= 10) {
                increaseQuality(item);
            }
            if (item.getSellIn() <= 5) {
                increaseQuality(item);
            }
        }
    }

    protected void updateItemSellin(Item item) {
        item.setSellIn(item.getSellIn() - 1);

    }

    protected void updateExpiredItem(Item item) {
        if ("Aged Brie".equals(item.getName())) {
            increaseQuality(item);
        } else {
            if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                item.setQuality(0);
            } else {

                reduceQuality(item);

                if ("Conjured Mana Cake".equals(item.getName())) {
                    reduceQuality(item);
                }
            }
        }
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
