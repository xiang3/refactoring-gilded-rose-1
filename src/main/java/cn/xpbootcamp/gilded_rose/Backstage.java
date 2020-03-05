package cn.xpbootcamp.gilded_rose;

public class Backstage extends Item {
    public Backstage(String name, int sell_in, int quality) {
        super(name, sell_in, quality);
    }

    @Override
    void updateQuality() {
        if (getQuality() < 50) {
            setQuality(getQuality() + 1);
            if (getSell_in() < 11 || getSell_in() < 6) {
                setQuality(getQuality() + 1);
            }
        }
    }

    @Override
    void updateSellIn() {
        setSell_in(getSell_in() - 1);
    }

    @Override
    void updateQualityExpired() {
        if (getSell_in() < 0) {
            setQuality(0);
        }
    }
}
