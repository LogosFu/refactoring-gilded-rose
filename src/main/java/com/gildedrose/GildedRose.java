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
            if (!item.name.equals(AGED_BRIE)
                    && !item.name.equals(TAFKL_80_ETC)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS)) {
                        item.tallyDownQuality();
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.plusOneQuality();

                    if (item.name.equals(TAFKL_80_ETC)) {
                        if (item.sell_in < 11) {
                            if (item.quality < 50) {
                                item.plusOneQuality();
                            }
                        }

                        if (item.sell_in < 6) {
                            if (item.quality < 50) {
                                item.plusOneQuality();
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sell_in = item.sell_in - 1;
            }

            if (item.sell_in < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(TAFKL_80_ETC)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS)) {
                                item.tallyDownQuality();
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.plusOneQuality();
                    }
                }
            }
        }
    }

}
