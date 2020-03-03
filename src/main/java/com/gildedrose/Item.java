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

    void updateItemQuality() {
        updateQuality();

        updateSellIn();

        if (isOverDue()) {
            updateQualityWhenOverDue();
        }
    }

    protected void updateQualityWhenOverDue() {
        if (isAgedBrie()) {
            if (quality < 50) {
                quality = quality + 1;
            }
        } else {
            if (isBackstage()) {
                quality = 0;
            } else {
                if (quality > 0) {
                    quality = quality - 1;
                }
            }
        }
    }

     protected boolean isOverDue() {
        return sell_in < 0;
    }

     protected void updateSellIn() {
        sell_in = sell_in - 1;
    }

     protected void updateQuality() {
        if (isAgedBrie()
            || isBackstage()) {
            if (quality < 50) {
                quality = quality + 1;

                if (isBackstage()) {
                    if (sell_in < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }

                    if (sell_in < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                }
            }
        } else {
            if (quality > 0) {
                quality = quality - 1;
            }
        }
    }

    protected boolean isSulfuras() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isBackstage() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }
}
