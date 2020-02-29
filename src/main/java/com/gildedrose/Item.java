package com.gildedrose;

import lombok.Getter;

@Getter
public class Item {

  public static final String AGED_BRIE = "Aged Brie";
  public static final String TAFKL_80_ETC = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  protected String name;
  protected int sellIn;
  protected int quality;

  public Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  public void plusOneQuality() {
    quality = quality + 1;
  }

  protected void tallyDownQuality() {
    quality = quality - 1;
  }

  void update() {
    if (name.equals(SULFURAS)) {
      return;
    }
    sellIn = sellIn - 1;
    switch (name) {
      case AGED_BRIE:
        roleForAgedBrie();
        break;
      case TAFKL_80_ETC:
        roleForTAFKL();
        break;
      default:
        roleForDefault();
        break;
    }
  }

  private void roleForDefault() {
    if (quality > 0) {
      tallyDownQuality();
    }
    if (sellIn < 0 && quality > 0) {
      tallyDownQuality();
    }
  }

  private void roleForAgedBrie() {
    if (quality < 50) {
      plusOneQuality();
    }
    if (sellIn < 0 && quality < 50) {
      plusOneQuality();
    }
  }

  private void roleForTAFKL() {
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
  }
}
