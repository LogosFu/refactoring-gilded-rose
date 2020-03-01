package com.gildedrose;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TexttestFixture {

    public static void main(String[] args) {
        GildedRose app = buildApp();
        int days = getDays(args);
        final String dailyReports = IntStream.range(0, days)
            .mapToObj(i -> getReportAndUpdateQuality(app, i)).collect(Collectors.joining());
        final String report = String.format("OMGHAI!%n%s", dailyReports);
        System.out.printf(report);
    }

    private static String getReportAndUpdateQuality(GildedRose app, int i) {
        final String dailyReport = getDailyReport(app, i);
        app.updateQuality();
        return dailyReport;
    }

    private static String getDailyReport(GildedRose app, int index) {
        String itemInfo = Arrays.stream(app.items).map(Item::toString)
            .collect(Collectors.joining("\n"));
        return String
            .format("-------- day %d --------%nname, sellIn, quality%n%s%n%n", index, itemInfo);
    }

    private static int getDays(String[] args) {
        int days = 3;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }
        return days;
    }
    private static GildedRose buildApp() {
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
        return new GildedRose(newItems);
    }
}
