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
  void update(){

    sellIn = sellIn - 1;
    if (quality < 50) {
      plusOneQuality();
    }
    if (sellIn < 0 && quality < 50) {
      plusOneQuality();
    }
  }
}
