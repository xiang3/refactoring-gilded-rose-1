package cn.xpbootcamp.gilded_rose;

public class ItemFactory {
    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    private static final String SULFURAS_HAND_OF_RAQNAROS = "Sulfuras, Hand of Ragnaros";

    public static Item createItem(String name, int sell_in, int quality) {
        switch (name) {
            case AGED_BRIE: return new AgedBric(name, sell_in, quality);
            case BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT: return new Backstage(name, sell_in, quality);
            case SULFURAS_HAND_OF_RAQNAROS: return new Sulfuras(name, sell_in, quality);
            default: return new Item(name, sell_in, quality);
        }
    }
}
