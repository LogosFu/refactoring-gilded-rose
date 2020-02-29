package com.gildedrose.item;

import com.gildedrose.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Sulfuras extends Item {

  @Builder
  public Sulfuras(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  public void update() {
    return;
  }
}
