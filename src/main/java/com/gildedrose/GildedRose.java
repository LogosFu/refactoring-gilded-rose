package com.gildedrose;

class GildedRose {

    Item[] items;
    public static final String AGED_BRIE = "Aged Brie";
    public static final String TAFKL_80_ETC = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            final Item item = items[i];
            item.update();
        }
    }

}
