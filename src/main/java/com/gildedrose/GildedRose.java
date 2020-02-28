package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            final Item item = items[i];
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.tallyDownQuality();
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.plusOneQuality();

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
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

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sell_in = item.sell_in - 1;
            }

            if (item.sell_in < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
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
