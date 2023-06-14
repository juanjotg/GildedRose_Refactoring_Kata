package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

	/**
	 * Comprobamos que al final de cada día el sistema decrementa sellIn y quality
	 * para cada artículo en una unidad
	 * 
	 */
	@Test
	void updateQuality() {

		Item[] items = new Item[] { new Item("commonProduct", 2, 2) };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(1, app.items[0].sellIn);
		assertEquals(1, app.items[0].quality);
		assertEquals("commonProduct", app.items[0].name);
	}

	/**
	 * Comprobamos una vez ha pasado fecha recomendada de venta, la calidad se
	 * degrada al doble de velocidad
	 */
	@Test
	void sellInExpired() {

		Item[] items = new Item[] { new Item("commonProduct", 0, 4) };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(2, app.items[0].quality);
	}

	/**
	 * La calidad de un artículo nunca es negativa
	 */
	@Test
	void qualityNeverNegative() {
				
		Item[] items = new Item[] {
                new Item("commonProduct", 2, 0), //                                                                                           
                new Item("Conjured product", 2, 0) };
		
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(0, app.items[0].quality);
		assertEquals(0, app.items[1].quality);
				
		items = new Item[] {
                new Item("commonProduct", 0, 0), //                                                                                       
                new Item("Conjured product", 0, 0) };
		
		app = new GildedRose(items);

		app.updateQuality();

		assertEquals(0, app.items[0].quality);
		assertEquals(0, app.items[1].quality);				
	}

	/**
	 * (Aged brie) incrementa su calidad en 1 unidad cada día
	 */
	@Test
	void agedBrieIncreasesQualityByOneUnitPerDay() {

		Item[] items = new Item[] { new Item("Aged Brie", 1, 4) };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(5, app.items[0].quality);
	}

	/**
	 * (Aged brie) incrementa su calidad en 2 unidades después de la fecha de venta.
	 */
	@Test
	void agedBrieIncreasesQualityByTwoUnitAfterExpired() {

		Item[] items = new Item[] { new Item("Aged Brie", 0, 4) };
		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(6, app.items[0].quality);
	}

	/**
	 * La calidad de un artículo nunca es mayor a 50
	 */
	@Test
	void qualityNeverHigherThanFifty() {

		Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(50, app.items[0].quality);
	}

	/**
	 * (Sulfuras), no modifica su fecha de venta ni se degrada en calidad
	 */
	@Test
	void sulfurasNotChangeSellInAndNotDecreaseQuality() {

		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 5) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(1, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	/**
	 * La calidad de un artículo nunca es mayor a 50 excepto (Sulfuras) posee una
	 * calidad inmutable de 80
	 */
	@Test
	void sulfurasImmutableQualityEighty() {

		Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(80, app.items[0].quality);
	}

	/**
	 * (Backstage passes to a TAFKAL80ETC concert) si faltan 10 días o menos la
	 * calidad se incrementa en 2 unidades
	 */
	@Test
	void backstageTenDaysOrLessQualityIncreasedByTwoUnits() {

		// Ten days
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(7, app.items[0].quality);

		// Less than ten days
		items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 8, 5) };

		app = new GildedRose(items);

		app.updateQuality();

		assertEquals(7, app.items[0].quality);
	}

	/**
	 * (Backstage passes to a TAFKAL80ETC concert) si faltan 5 días o menos, la
	 * calidad se incrementa en 3 unidades
	 */
	@Test
	void backstageFiveDaysOrLessQualityIncreasedByThreeUnits() {

		// Five days
		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(8, app.items[0].quality);

		// Less than five days
		items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 5) };

		app = new GildedRose(items);

		app.updateQuality();

		assertEquals(8, app.items[0].quality);
	}

	/**
	 * (Backstage passes to a TAFKAL80ETC concert) después de la fecha de venta la
	 * calidad cae a 0
	 */
	@Test
	void backstageAfterSellInQualityFallCero() {

		Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(0, app.items[0].quality);
	}

	/**
	 * (Conjured Product) Degrada su calidad al doble de velocidad que los productos
	 * normales
	 */
	@Test
	void conjuredProductDecreasedQualityDouble() {

		Item[] items = new Item[] { new Item("Conjured Product", 2, 5) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(3, app.items[0].quality);
	}

	/**
	 * (Conjured Product) después de la fecha de venta degrada su calidad al doble
	 * de velocidad que los productos normales
	 */
	@Test
	void conjuredProductAfterSellInDecreasedQualityDouble() {

		Item[] items = new Item[] { new Item("Conjured Product", 0, 5) };

		GildedRose app = new GildedRose(items);

		app.updateQuality();

		assertEquals(1, app.items[0].quality);
	}

}