package com.gildedrose

import com.gildedrose.item.AgedBrie
import com.gildedrose.item.Backstage
import com.gildedrose.item.NormalItem
import com.gildedrose.item.Sulfuras
import spock.lang.Specification

class ItemTest extends Specification {

    def AGED_BRIE = "Aged Brie";
    def TAFKL_80_ETC = "Backstage passes to a TAFKAL80ETC concert";
    def SULFURAS = "Sulfuras, Hand of Ragnaros";
    def OTHER = "other"

    def "test role for other name item"(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        expect:
        def item = NormalItem.builder().sellIn(sellIn).quality(quality).name(OTHER).build()
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
        def item = AgedBrie.builder().sellIn(sellIn).quality(quality).name(AGED_BRIE).build()
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

    def "test role for TAFKL_80_ETC name item"(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        expect:
        def item = Backstage.builder().sellIn(sellIn).quality(quality).name(TAFKL_80_ETC).build()
        item.update()
        item.quality == updatedQuality
        item.sellIn == updatedSellIn
        where:
        sellIn | quality || updatedSellIn | updatedQuality
        -1     | 48      || -2            | 0
        -1     | 49      || -2            | 0
        -1     | 51      || -2            | 0
        1      | 51      || 0             | 51
        1      | 49      || 0             | 50
        1      | 47      || 0             | 50
        1      | -3      || 0             | 0
        7      | 48      || 6             | 50
        7      | -2      || 6             | 0
        12     | 49      || 11            | 50
        12     | -1      || 11            | 0
    }

    def "test role for SULFURAS item"(int sellIn, int quality, int updatedSellIn, int updatedQuality) {
        expect:
        def item = Sulfuras.builder().sellIn(sellIn).quality(quality).name(SULFURAS).build()
        item.update()
        item.quality == updatedQuality
        item.sellIn == updatedSellIn
        where:
        sellIn | quality || updatedSellIn | updatedQuality
        -1     | 51      || -1            | 51
        -1     | -1      || -1            | -1
        1      | 51      || 1             | 51
        1      | -1      || 1             | -1
        1      | 49      || 1             | 49
    }
}
