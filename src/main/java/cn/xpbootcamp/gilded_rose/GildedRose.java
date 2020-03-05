package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.item.Item;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItemsQualityAndSellIn() {
        Arrays.stream(items).forEach(Item::updateQualityAndSellIn);
    }
}
