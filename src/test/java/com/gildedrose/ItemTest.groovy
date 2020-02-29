package com.gildedrose

import spock.lang.Specification

class ItemTest extends Specification {

    def AGED_BRIE = "Aged Brie";
    def TAFKL_80_ETC = "Backstage passes to a TAFKAL80ETC concert";
    def SULFURAS = "Sulfuras, Hand of Ragnaros";
    def OTHER = "other"

    def "test role for other name item"(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        expect:
        def item = Item.builder().sellIn(sellIn).quality(quality).name(OTHER).build()
        item.update()
        item.quality == updatedQuality
        item.sellIn == updatedSellIn
        where:
        sellIn | quality || updatedSellIn | updatedQuality
        -1     | 51      || -2            | 49
        -1     | -1      || -2            | -1
        1      | 51      || 0             | 50
        1      | -1      || 0             | -1
    }

    def "test role for AGED BRIE name item"(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        expect:
        def item = Item.builder().sellIn(sellIn).quality(quality).name(AGED_BRIE).build()
        item.update()
        item.quality == updatedQuality
        item.sellIn == updatedSellIn
        where:
        sellIn | quality || updatedSellIn | updatedQuality
        -1     | 48      || -2            | 50
        -1     | 49      || -2            | 50
        -1     | 51      || -2            | 51
        1      | 51      || 0             | 51
        1      | -1      || 0             | 0
    }
}
