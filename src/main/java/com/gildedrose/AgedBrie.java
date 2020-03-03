package com.gildedrose;

public class AgedBrie extends Item {

  public AgedBrie(int sell_in, int quality) {
    super("Aged Brie", sell_in, quality);
  }

  @Override
  protected void updateQualityWhenOverDue() {
    if (quality < 50) {
      quality = quality + 1;
    }
  }

  @Override
  protected void updateQuality() {
    if (quality < 50) {
      quality = quality + 1;
    }
  }
}
