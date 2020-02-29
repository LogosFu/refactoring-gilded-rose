package com.gildedrose

import spock.lang.Specification

class ItemTest extends Specification {

    def AGED_BRIE = "Aged Brie";
    def TAFKL_80_ETC = "Backstage passes to a TAFKAL80ETC concert";
    def SULFURAS = "Sulfuras, Hand of Ragnaros";
    def OTHER = "other"

    def "should return 49 when update quality given normal name with sell in =-1 and quality is 51"() {
        given:
        def item = Item.builder().sellIn(-1).quality(51).name(OTHER).build()
        when:
        item.update()
        then:
        item.quality == 49
        item.sellIn == -2
    }

    def "should return -1 when update quality given normal name with sell in = -1 and quality is -2"() {
        given:
        def item = Item.builder().sellIn(-1).quality(-1).name(OTHER).build()
        when:
        item.update()
        then:
        item.quality == -1
        item.sellIn == -2
    }
    def "should return 50 when update quality given normal name with sell in = 1 and quality is 51"() {
        given:
        def item = Item.builder().sellIn(1).quality(51).name(OTHER).build()
        when:
        item.update()
        then:
        item.quality == 50
        item.sellIn == 0
    }
    def "should return -1 when update quality given normal name with sell in = 1 and quality is -1"() {
        given:
        def item = Item.builder().sellIn(1).quality(-1).name(OTHER).build()
        when:
        item.update()
        then:
        item.quality == -1
        item.sellIn == 0
    }
}
