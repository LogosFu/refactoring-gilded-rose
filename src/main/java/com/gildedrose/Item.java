package com.gildedrose;

public class Item {

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
        if (!name.equals(GildedRose.AGED_BRIE)
                && !name.equals(GildedRose.TAFKL_80_ETC)) {
            if (quality > 0) {
                if (!name.equals(GildedRose.SULFURAS)) {
                    tallyDownQuality();
                }
            }
        } else {
            if (quality < 50) {
                plusOneQuality();

                if (name.equals(GildedRose.TAFKL_80_ETC)) {
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

        if (!name.equals(GildedRose.SULFURAS)) {
            sell_in = sell_in - 1;
        }

        if (sell_in < 0) {
            if (!name.equals(GildedRose.AGED_BRIE)) {
                if (!name.equals(GildedRose.TAFKL_80_ETC)) {
                    if (quality > 0) {
                        if (!name.equals(GildedRose.SULFURAS)) {
                            tallyDownQuality();
                        }
                    }
                } else {
                    quality = 0;
                }
            } else {
                if (quality < 50) {
                    plusOneQuality();
                }
            }
        }
    }
}
