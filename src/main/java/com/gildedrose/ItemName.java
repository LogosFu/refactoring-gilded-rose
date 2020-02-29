package com.gildedrose;

public enum ItemName {
  AGED_BRIE("Aged Brie"),
  BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
  SULFURAS("Sulfuras, Hand of Ragnaros"),
  DEFAULT("default");

  private String name;

  ItemName(String name) {
    this.name = name;
  }

  public static ItemName getName(String name) {
    switch (name) {
      case "Aged Brie":
        return AGED_BRIE;
      case "Backstage passes to a TAFKAL80ETC concert":
        return BACKSTAGE;
      case "Sulfuras, Hand of Ragnaros":
        return SULFURAS;
      default:
        return DEFAULT;
    }
  }
}
