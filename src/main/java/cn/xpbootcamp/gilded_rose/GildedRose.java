package cn.xpbootcamp.gilded_rose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (Item item : items) {
            updateQuality(item);

            updateSellIn(item);

            updateQualityExpired(item);
        }
    }

    private void updateQualityExpired(Item item) {
        if (item.sell_in < 0) {
            if (!item.isAgedBrie()) {
                if (!item.isBackstage()) {
                    if (item.quality > 0) {
                        if (!item.isSulfuras()) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!item.isSulfuras()) {
            item.sell_in = item.sell_in - 1;
        }
    }

    private void updateQuality(Item item) {
        if (!item.isAgedBrie()
                && !item.isBackstage()) {
            if (item.quality > 0) {
                if (!item.isSulfuras()) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.isBackstage()) {
                    if (item.sell_in < 11) {
                        item.quality = item.quality + 1;
                    }

                    if (item.sell_in < 6) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
