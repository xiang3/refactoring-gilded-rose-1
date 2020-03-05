package cn.xpbootcamp.gilded_rose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        Arrays.stream(items).forEach(item -> {
            item.updateQuality();

            item.updateSellIn();

            item.updateQualityExpired();
        });
    }
}
