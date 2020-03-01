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
    tallyDownSellIn();
    if (qualityMoreThanMax()) {
      plusOneQuality();
      if (sellIn < 11 && qualityMoreThanMax()) {
        plusOneQuality();
      }
      if (sellIn < 6 && qualityMoreThanMax()) {
        plusOneQuality();
      }
    }
    if (sellInUnderZero()) {
      quality = 0;
    }
  }

}
