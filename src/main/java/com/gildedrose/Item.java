package com.gildedrose;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String TAFKL_80_ETC = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public String name;

    public int sell_in;

    public int quality;

    public Item(String name, int sell_in, int quality) {
        this.name = name;
        this.sell_in = sell_in;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sell_in + ", " + this.quality;
    }

    void plusOneQuality() {
        quality = quality + 1;
    }

    void tallyDownQuality() {
        quality = quality - 1;
    }

    void update() {
        if (!name.equals(AGED_BRIE)
                && !name.equals(TAFKL_80_ETC)) {
            if (quality > 0 && !name.equals(SULFURAS)) {
                    tallyDownQuality();
            }
        } else {
            if (quality < 50) {
                plusOneQuality();

                if (name.equals(TAFKL_80_ETC)) {
                    if (sell_in < 11) {
                        if (quality < 50) {
                            plusOneQuality();
                        }
                    }

                    if (sell_in < 6) {
                        if (quality < 50) {
                            plusOneQuality();
                        }
                    }
                }
            }
        }

        if (!name.equals(SULFURAS)) {
            sell_in = sell_in - 1;
        }

        if (sell_in < 0) {
            if (name.equals(AGED_BRIE)) {
                if (quality < 50) {
                    plusOneQuality();
                }
            } else {
                if (name.equals(TAFKL_80_ETC)) {
                    quality = 0;
                } else {
                    if (quality > 0) {
                        if (!name.equals(SULFURAS)) {
                            tallyDownQuality();
                        }
                    }
                }
            }
        }
    }
}
