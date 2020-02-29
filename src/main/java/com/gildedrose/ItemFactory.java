package com.gildedrose;

import com.gildedrose.item.AgedBrie;
import com.gildedrose.item.Backstage;
import com.gildedrose.item.NormalItem;
import com.gildedrose.item.Sulfuras;

public class ItemFactory {

  public Item getItem(ItemDTO item) {
    Item newItem = null;
    switch (ItemName.getName(item.getName())) {
      case SULFURAS:
        newItem = Sulfuras.builder().name(item.getName()).quality(item.getQuality())
            .sellIn(item.getSellIn()).build();
        break;
      case AGED_BRIE:
        newItem = AgedBrie.builder().name(item.getName()).quality(item.getQuality())
            .sellIn(item.getSellIn()).build();
        break;
      case BACKSTAGE:
        newItem = Backstage.builder().name(item.getName()).quality(item.getQuality())
            .sellIn(item.getSellIn()).build();
        break;
      case DEFAULT:
        newItem = NormalItem.builder().name(item.getName()).quality(item.getQuality())
            .sellIn(item.getSellIn()).build();
        break;
    }
    return newItem;
  }
}
