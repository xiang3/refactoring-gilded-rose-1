package cn.xpbootcamp.gilded_rose.item;

public class AgedBric extends Item {
    public AgedBric(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    public void updateQuality() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
        }
    }

    @Override
    public void updateSellIn() {
        setSellIn(getSellIn() - 1);
    }

    @Override
    public void updateQualityExpired() {
        if (getSellIn() < 0) {
            if (getQuality() < 50) {
                setQuality(getQuality() + 1);
            }
        }
    }

}
