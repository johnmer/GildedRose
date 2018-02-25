public class ItemType {
    public static ItemType determineItemType(Item item) {
        if (item.getName() == "Sulfuras, Hand of Ragnaros")
            return new SulfuraItemType();
        if (item.getName() == "Aged Brie")
            return new BrieItemType();
        if (item.getName() == "Backstage passes to a TAFKAL80ETC concert")
            return new BackStageItemType();
        if (item.getName() == "Conjured Mana Cake")
            return new ConjurItemType();
        return new StandardItemType();
    }
}
