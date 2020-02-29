package com.gildedrose.item;

import com.gildedrose.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Backstage extends Item {

  @Builder
  public Backstage(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void update() {
    sellIn = sellIn - 1;
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
