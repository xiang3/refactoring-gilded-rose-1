package cn.xpbootcamp.gilded_rose.item;

public class Item {
    private String name;

    private int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sell_in) {
        this.sellIn = sell_in;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getSellIn() + ", " + this.getQuality();
    }

    public void updateQualityExpired() {
        if (getSellIn() < 0 && getQuality() > 0) {
            setQuality(getQuality() - 1);
        }
    }

    public void updateQuality() {
        if (getQuality() > 0) {
            setQuality(getQuality() - 1);
        }
    }

    public void updateSellIn() {
            setSellIn(getSellIn() - 1);
    }

    public void updateQualityAndSellIn() {
        updateQuality();

        updateSellIn();

        updateQualityExpired();
    }
}
