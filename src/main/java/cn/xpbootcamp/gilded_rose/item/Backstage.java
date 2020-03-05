package cn.xpbootcamp.gilded_rose.item;

public class Backstage extends Item {
    public Backstage(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void updateQuality() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
            if (getSellIn() < 11) {
                setQuality(getQuality() + 1);
            }

            if (getSellIn() < 6) {
                setQuality(getQuality() + 1);
            }
        }
    }

    @Override
    public void updateSellIn() {
        setSellIn(getSellIn() - 1);
    }

    @Override
    public void updateQualityExpired() {
        if (getSellIn() < 0) {
            setQuality(0);
        }
    }
}
