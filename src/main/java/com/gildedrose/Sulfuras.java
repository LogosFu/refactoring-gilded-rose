package com.gildedrose;

public class Sulfuras extends Item {

  public Sulfuras(int sell_in, int quality) {
    super("Sulfuras, Hand of Ragnaros", sell_in, quality);
  }

  @Override
  protected void updateQuality() {

  }

  @Override
  protected void updateSellIn() {

  }

  @Override
  protected void updateQualityWhenOverDue() {
  }

  @Override
  protected boolean isSulfuras() {
    return true;
  }
}
