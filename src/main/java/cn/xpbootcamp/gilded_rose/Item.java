package cn.xpbootcamp.gilded_rose;

public class Item {
    private String name;

    private int sell_in;

    private int quality;

    public Item(String name, int sell_in, int quality) {
        this.setName(name);
        this.setSell_in(sell_in);
        this.setQuality(quality);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSell_in() {
        return sell_in;
    }

    public void setSell_in(int sell_in) {
        this.sell_in = sell_in;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getSell_in() + ", " + this.getQuality();
    }

    boolean isAgedBrie() {
        return getName().equals("Aged Brie");
    }

    boolean isBackstage() {
        return getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    boolean isSulfuras() {
        return getName().equals("Sulfuras, Hand of Ragnaros");
    }

    void updateQualityExpired() {
        if (getSell_in() < 0) {
            if (!isAgedBrie()) {
                if (!isBackstage()) {
                    if (getQuality() > 0) {
                        if (!isSulfuras()) {
                            setQuality(getQuality() - 1);
                        }
                    }
                } else {
                    setQuality(0);
                }
            } else {
                if (getQuality() < 50) {
                    setQuality(getQuality() + 1);
                }
            }
        }
    }

    void updateQuality() {
        if (!isAgedBrie() && !isBackstage()) {
            if (getQuality() > 0) {
                if (!isSulfuras()) {
                    setQuality(getQuality() - 1);
                }
            }
        } else {
            if (getQuality() < 50) {
                setQuality(getQuality() + 1);

                if (isBackstage()) {
                    if (getSell_in() < 11) {
                        setQuality(getQuality() + 1);
                    }

                    if (getSell_in() < 6) {
                        setQuality(getQuality() + 1);
                    }
                }
            }
        }
    }

    void updateSellIn() {
        if (!isSulfuras()) {
            setSell_in(getSell_in() - 1);
        }
    }
}
