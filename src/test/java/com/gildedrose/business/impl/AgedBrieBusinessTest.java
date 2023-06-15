package com.gildedrose.business.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.business.IProduct;
import com.gildedrose.dto.Item;

public class AgedBrieBusinessTest {
	
	/**
	 * (Aged brie) incrementa su calidad en 1 unidad cada día
	 */
	@Test
	void agedBrieIncreasesQualityByOneUnitPerDay() {
		
		Item item = new Item("Aged Brie", 1, 4);

		IProduct agedBrie = new AgedBrieBusiness();
		
		item.sellIn = agedBrie.manageSellIn(item.sellIn);
		item = agedBrie.manageQuality(item);	

		assertEquals(5, item.quality);
		assertEquals(0, item.sellIn);
	}

	/**
	 * (Aged brie) incrementa su calidad en 2 unidades después de la fecha de venta.
	 */
	@Test
	void agedBrieIncreasesQualityByTwoUnitAfterExpired() {

		Item item = new Item("Aged Brie", 0, 4);
		
		IProduct agedBrie = new AgedBrieBusiness();
		
		item.sellIn = agedBrie.manageSellIn(item.sellIn);
		item = agedBrie.manageQuality(item);	

		assertEquals(6, item.quality);
	}

	/**
	 * La calidad de un artículo nunca es mayor a 50
	 */
	@Test
	void qualityNeverHigherThanFifty() {

		Item item = new Item("Aged Brie", 1, 50);
		
		IProduct agedBrie = new AgedBrieBusiness();
		
		item.sellIn = agedBrie.manageSellIn(item.sellIn);
		item = agedBrie.manageQuality(item);	

		assertEquals(50, item.quality);
	}
}
