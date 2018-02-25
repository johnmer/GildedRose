import java.util.ArrayList;
import java.util.List;


public class GildedRose {

    private static List<Item> items = null;

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        GildedRose.items = items;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
    }

    public static void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        updateItemQuality(item);

        updateItemSellin(item);

        if (item.getSellIn() < 0) {
            updateExpiredItem(item);
        }
    }

    private static void updateExpiredItem(Item item) {
        if ("Aged Brie".equals(item.getName())) {
            increaseQuality(item);
        } else {
            if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                item.setQuality(0);
            } else {
                if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                    reduceQuality(item);
                }
            }
        }
    }

    private static void updateItemSellin(Item item) {
        if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private static void updateItemQuality(Item item) {
        if ((!"Aged Brie".equals(item.getName())) && !"Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
            if (item.getQuality() > 0) {
                if (!"Sulfuras, Hand of Ragnaros".equals(item.getName())) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        } else {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);

                if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
                    if (item.getSellIn() <= 10) {
                        increaseQuality(item);
                    }

                    if (item.getSellIn() <= 5) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    private static void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    private static void reduceQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }
}