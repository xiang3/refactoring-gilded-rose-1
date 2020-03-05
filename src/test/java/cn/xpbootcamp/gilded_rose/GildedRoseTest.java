package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].getName());
        assertThat(app.items[0].getQuality()).isEqualTo(4);
        assertThat(app.items[0].getSellIn()).isEqualTo(0);
    }

    @Test
    public void return_item_when_updated_twice() {
        Item[] items = new Item[] {
                ItemFactory.createItem("+5 Dexterity Vest", 10, 20),
                ItemFactory.createItem("Aged Brie", 2, 0),
                ItemFactory.createItem("Elixir of the Mongoose", 5, 7),
                ItemFactory.createItem("Sulfuras, Hand of Ragnaros", 0, 80),
                ItemFactory.createItem("Sulfuras, Hand of Ragnaros", -1, 80),
                ItemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                ItemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                ItemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                ItemFactory.createItem("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                ItemFactory.createItem("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        app.updateQuality();
        assertEquals("[+5 Dexterity Vest, 9, 19, Aged Brie, 1, 1, Elixir of the Mongoose, 4, 6, Sulfuras, Hand of Ragnaros, 0, 80, Sulfuras, Hand of Ragnaros, -1, 80, Backstage passes to a TAFKAL80ETC concert, 14, 21, Backstage passes to a TAFKAL80ETC concert, 9, 51, Backstage passes to a TAFKAL80ETC concert, 4, 52, Backstage passes to a TAFKAL80ETC concert, 0, 23, Conjured Mana Cake, 2, 5]"
                , Arrays.toString(items));

        app.updateQuality();
        assertEquals("[+5 Dexterity Vest, 8, 18, Aged Brie, 0, 2, Elixir of the Mongoose, 3, 5, Sulfuras, Hand of Ragnaros, 0, 80, Sulfuras, Hand of Ragnaros, -1, 80, Backstage passes to a TAFKAL80ETC concert, 13, 22, Backstage passes to a TAFKAL80ETC concert, 8, 51, Backstage passes to a TAFKAL80ETC concert, 3, 52, Backstage passes to a TAFKAL80ETC concert, -1, 0, Conjured Mana Cake, 1, 4]"
                , Arrays.toString(items));
    }
}
