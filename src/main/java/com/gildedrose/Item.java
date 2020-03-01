package com.gildedrose;

import lombok.Getter;

@Getter
public abstract class Item {

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

  public abstract void update();

  protected boolean qualityMoreThanMax() {
    return quality < 50;
  }

  protected boolean sellInUnderZero() {
    return sellIn < 0;
  }

  protected boolean qualityMoreThanZero() {
    return quality > 0;
  }

  protected void tallyDownSellIn() {
    sellIn = sellIn - 1;
  }
}
