package com.gildedrose;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
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
    if (name.equals(SULFURAS)) {
      return;
    }
    sellIn = sellIn - 1;
    switch (name) {
      case AGED_BRIE:
        if (quality < 50) {
          plusOneQuality();
        }
        if (sellIn < 0 && quality < 50) {
          plusOneQuality();
        }
        break;
      case TAFKL_80_ETC:
        if (quality < 50) {
          plusOneQuality();
          if (sellIn < 11 && quality < 50) {
            plusOneQuality();
          }
          if (sellIn < 6 && quality < 50) {
            plusOneQuality();
          }
        }
        if (sellIn < 0) {
          quality = 0;
        }
        break;
      default:
        if (quality > 0) {
          tallyDownQuality();
        }
        if (sellIn < 0 && quality > 0) {
          tallyDownQuality();
        }
        break;
    }
  }
}
