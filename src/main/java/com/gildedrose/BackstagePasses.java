package com.gildedrose;

public class BackstagePasses extends Item {

  public BackstagePasses(int sell_in, int quality) {
    super("Backstage passes to a TAFKAL80ETC concert", sell_in, quality);
  }

  @Override
  protected void updateQualityWhenOverDue() {
    quality = 0;
  }

  @Override
  protected void updateQuality() {
    if (quality < 50) {
      quality = quality + 1;
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

}
