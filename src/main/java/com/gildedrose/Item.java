package com.gildedrose;

public class Item {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String TAFKL_80_ETC = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  private String name;

  private int sellIn;

  private int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  void plusOneQuality() {
    quality = quality + 1;
  }

  void tallyDownQuality() {
    quality = quality - 1;
  }

  void update() {
    if (!name.equals(SULFURAS)) {
      sellIn = sellIn - 1;
    }
    if (!name.equals(AGED_BRIE)
        && !name.equals(TAFKL_80_ETC)) {
      if (quality > 0 && !name.equals(SULFURAS)) {
        tallyDownQuality();
      }
    } else {
      if (quality < 50) {
        plusOneQuality();

        if (name.equals(TAFKL_80_ETC)) {
          if (sellIn < 11 && quality < 50) {
            plusOneQuality();
          }

          if (sellIn < 6 && quality < 50) {
            plusOneQuality();
          }
        }
      }
    }

    if (sellIn < 0) {
      if (name.equals(AGED_BRIE)) {
        if (quality < 50) {
          plusOneQuality();
        }
      } else {
        if (name.equals(TAFKL_80_ETC)) {
          quality = 0;
        } else {
          if (quality > 0 && !name.equals(SULFURAS)) {
            tallyDownQuality();
          }
        }
      }
    }
  }
}
