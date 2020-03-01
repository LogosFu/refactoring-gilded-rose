package com.gildedrose.item;

import com.gildedrose.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
public class NormalItem extends Item {

  @Builder
  public NormalItem(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }
  public void update(){
    tallyDownSellIn();
    if (qualityMoreThanZero()) {
      tallyDownQuality();
    }
    if (sellInUnderZero() && qualityMoreThanZero()) {
      tallyDownQuality();
    }
  }
}

