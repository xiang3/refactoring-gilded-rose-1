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
        app.update_quality();
        assertEquals("foo", app.items[0].getName());
        assertThat(app.items[0].getQuality()).isEqualTo(4);
        assertThat(app.items[0].getSell_in()).isEqualTo(0);
    }

    @Test
    public void return_item_when_updated_twice() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        app.update_quality();


        assertEquals("[+5 Dexterity Vest, 9, 19, Aged Brie, 1, 1, Elixir of the Mongoose, 4, 6, Sulfuras, Hand of Ragnaros, 0, 80, Sulfuras, Hand of Ragnaros, -1, 80, Backstage passes to a TAFKAL80ETC concert, 14, 21, Backstage passes to a TAFKAL80ETC concert, 9, 51, Backstage passes to a TAFKAL80ETC concert, 4, 52, Backstage passes to a TAFKAL80ETC concert, 0, 23, Conjured Mana Cake, 2, 5]"
                , Arrays.toString(items));

        app.update_quality();
        assertEquals("[+5 Dexterity Vest, 8, 18, Aged Brie, 0, 2, Elixir of the Mongoose, 3, 5, Sulfuras, Hand of Ragnaros, 0, 80, Sulfuras, Hand of Ragnaros, -1, 80, Backstage passes to a TAFKAL80ETC concert, 13, 22, Backstage passes to a TAFKAL80ETC concert, 8, 51, Backstage passes to a TAFKAL80ETC concert, 3, 52, Backstage passes to a TAFKAL80ETC concert, -1, 0, Conjured Mana Cake, 1, 4]"
                , Arrays.toString(items));
    }
}
