package cn.xpbootcamp.gilded_rose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            item.updateQuality();

            item.updateSellIn();

            item.updateQualityExpired();
        });
    }
}
