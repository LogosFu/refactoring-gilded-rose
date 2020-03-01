package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        ItemDTO[] items = new ItemDTO[]{new ItemDTO("foo", 1, 5)};
        final Item[] newItems = Arrays.stream(items).map(ItemFactory::getItem).toArray(Item[]::new);
        GildedRose app = new GildedRose(newItems);
        app.updateQuality();
        assertEquals("foo", app.items[0].getName());
        assertThat(app.items[0].getQuality(), is(4));
        assertThat(app.items[0].getSellIn(), is(0));
    }

}
