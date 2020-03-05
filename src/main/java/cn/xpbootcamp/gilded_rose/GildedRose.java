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
        if (item.getSell_in() < 0) {
            if (!item.isAgedBrie()) {
                if (!item.isBackstage()) {
                    if (item.getQuality() > 0) {
                        if (!item.isSulfuras()) {
                            item.setQuality(item.getQuality() - 1);
                        }
                    }
                } else {
                    item.setQuality(0);
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!item.isSulfuras()) {
            item.setSell_in(item.getSell_in() - 1);
        }
    }

    private void updateQuality(Item item) {
        if (!item.isAgedBrie() && !item.isBackstage()) {
            if (item.getQuality() > 0) {
                if (!item.isSulfuras()) {
                    item.setQuality(item.getQuality() - 1);
                }
            }
        } else {
            if (item.getQuality() < 50) {
                item.setQuality(item.getQuality() + 1);

                if (item.isBackstage()) {
                    if (item.getSell_in() < 11) {
                        item.setQuality(item.getQuality() + 1);
                    }

                    if (item.getSell_in() < 6) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }
}
