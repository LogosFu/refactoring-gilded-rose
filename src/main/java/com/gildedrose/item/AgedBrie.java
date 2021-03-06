package com.gildedrose.item;

import com.gildedrose.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AgedBrie extends Item {
@Builder
  public AgedBrie(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }
  public void update(){

    tallyDownSellIn();
    if (qualityMoreThanMax()) {
      plusOneQuality();
    }
    if (sellInUnderZero() && qualityMoreThanMax()) {
      plusOneQuality();
    }
  }

}
