import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GildedRoseTest {

    @Before
    public void setUp() {

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        items.add(new Item("Conjured Mana Cake", 0, 6));

        GildedRose.setItems(items);
    }


    @Test
    public void testUpdateSellinNormalItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(0).getSellIn() == 9);
    }

    @Test
    public void testUpdateQualityNormalItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(0).getQuality() == 19);
    }

    @Test
    public void testUpdateSellinCheeseItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(1).getSellIn() == 1);
    }

    @Test
    public void testUpdateQualityCheeseItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(1).getQuality() == 1);
    }

    @Test
    public void testUpdateSellinSulfuraItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(3).getSellIn() == 0);
    }

    @Test
    public void testUpdateQualitySulfuraItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(3).getQuality() == 80);
    }

    @Test
    public void testUpdateSellinBackStageItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(4).getSellIn() == 14);
    }

    @Test
    public void testUpdateQualityBackStageItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(4).getQuality() == 21);
    }

    @Test
    public void testUpdateSellinBackStage3DayItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(5).getSellIn() == 2);
    }

    @Test
    public void testUpdateQualityBackStage3DayItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(5).getQuality() == 23);
    }

    @Test
    public void testUpdateSellinConjurItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(6).getSellIn() == 2);
    }

    @Test
    public void testUpdateQualityConjurItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(6).getQuality() == 4);
    }

    @Test
    public void testUpdateSellinExpiredConjurItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(7).getSellIn() == -1);
    }

    @Test
    public void testUpdateQualityExpiredConjurItem() {
        GildedRose.updateQuality();
        assertTrue(GildedRose.getItems().get(7).getQuality() == 2);
    }
}
