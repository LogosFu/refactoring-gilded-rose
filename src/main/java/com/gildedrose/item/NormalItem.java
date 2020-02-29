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
    sellIn = sellIn - 1;
    if (quality > 0) {
      tallyDownQuality();
    }
    if (sellIn < 0 && quality > 0) {
      tallyDownQuality();
    }
  }
}

