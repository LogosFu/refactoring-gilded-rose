package com.gildedrose;

import java.util.Arrays;

public class TexttestFixture {

    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        ItemDTO[] items = new ItemDTO[]{
            new ItemDTO("+5 Dexterity Vest", 10, 20), //
            new ItemDTO("Aged Brie", 2, 0), //
            new ItemDTO("Elixir of the Mongoose", 5, 7), //
            new ItemDTO("Sulfuras, Hand of Ragnaros", 0, 80), //
            new ItemDTO("Sulfuras, Hand of Ragnaros", -1, 80),
            new ItemDTO("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new ItemDTO("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new ItemDTO("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new ItemDTO("Backstage passes to a TAFKAL80ETC concert", 1, 20),
            // this conjured item does not work properly yet
            new ItemDTO("Conjured Mana Cake", 3, 6)};
        final Item[] newItems = Arrays.stream(items).map(ItemFactory::getItem).toArray(Item[]::new);

        GildedRose app = new GildedRose(newItems);

        int days = 3;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            Arrays.stream(app.items).forEach(System.out::println);
            System.out.println();
            app.updateQuality();
        }
    }
}
