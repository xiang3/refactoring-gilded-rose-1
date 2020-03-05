package cn.xpbootcamp.gilded_rose;

public class AgedBric extends Item {
    public AgedBric(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    void updateQuality() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
    }

    @Override
    void updateSellIn() {
        setSellIn(getSellIn() - 1);
    }

    @Override
    void updateQualityExpired() {
        if (getSellIn() < 0) {
            if (getQuality() < 50) {
                setQuality(getQuality() + 1);
            }
        }
    }

}
