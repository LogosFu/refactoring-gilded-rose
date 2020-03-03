package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class TexttestFixtureTest {

  @Rule
  public final SystemOutRule log = new SystemOutRule().enableLog();
  private String result="OMGHAI!\n"
      + "-------- day 0 --------\n"
      + "name, sellIn, quality\n"
      + "+5 Dexterity Vest, 10, 20\n"
      + "Aged Brie, 2, 0\n"
      + "Elixir of the Mongoose, 5, 7\n"
      + "Sulfuras, Hand of Ragnaros, 0, 80\n"
      + "Sulfuras, Hand of Ragnaros, -1, 80\n"
      + "Backstage passes to a TAFKAL80ETC concert, 15, 20\n"
      + "Backstage passes to a TAFKAL80ETC concert, 10, 49\n"
      + "Backstage passes to a TAFKAL80ETC concert, 5, 49\n"
      + "Backstage passes to a TAFKAL80ETC concert, 1, 20\n"
      + "Conjured Mana Cake, 3, 6\n"
      + "\n"
      + "-------- day 1 --------\n"
      + "name, sellIn, quality\n"
      + "+5 Dexterity Vest, 9, 19\n"
      + "Aged Brie, 1, 1\n"
      + "Elixir of the Mongoose, 4, 6\n"
      + "Sulfuras, Hand of Ragnaros, 0, 80\n"
      + "Sulfuras, Hand of Ragnaros, -1, 80\n"
      + "Backstage passes to a TAFKAL80ETC concert, 14, 21\n"
      + "Backstage passes to a TAFKAL80ETC concert, 9, 50\n"
      + "Backstage passes to a TAFKAL80ETC concert, 4, 50\n"
      + "Backstage passes to a TAFKAL80ETC concert, 0, 23\n"
      + "Conjured Mana Cake, 2, 5\n"
      + "\n"
      + "-------- day 2 --------\n"
      + "name, sellIn, quality\n"
      + "+5 Dexterity Vest, 8, 18\n"
      + "Aged Brie, 0, 2\n"
      + "Elixir of the Mongoose, 3, 5\n"
      + "Sulfuras, Hand of Ragnaros, 0, 80\n"
      + "Sulfuras, Hand of Ragnaros, -1, 80\n"
      + "Backstage passes to a TAFKAL80ETC concert, 13, 22\n"
      + "Backstage passes to a TAFKAL80ETC concert, 8, 50\n"
      + "Backstage passes to a TAFKAL80ETC concert, 3, 50\n"
      + "Backstage passes to a TAFKAL80ETC concert, -1, 0\n"
      + "Conjured Mana Cake, 1, 4\n\n";

  @Test
  public void play() {
    String[] arg = new String[0];
    TexttestFixture.main(arg);
    assertThat(log.getLog()).isEqualTo(result);
  }
}