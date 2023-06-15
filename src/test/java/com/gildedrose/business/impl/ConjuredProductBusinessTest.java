package com.gildedrose.business.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.gildedrose.business.IProduct;
import com.gildedrose.dto.Item;

public class ConjuredProductBusinessTest {
	
	/**
	 * (Conjured Product) Degrada su calidad al doble de velocidad que los productos
	 * normales
	 */
	@Test
	void conjuredProductDecreasedQualityDouble() {

		Item item = new Item("Conjured Product", 2, 5);
		
		IProduct conjuredProduct = new ConjuredProductBusiness();
		
		item.sellIn = conjuredProduct.manageSellIn(item.sellIn);
		item = conjuredProduct.manageQuality(item);				

		assertEquals(3, item.quality);
	}

	/**
	 * (Conjured Product) después de la fecha de venta degrada su calidad al doble
	 * de velocidad que los productos normales
	 */
	@Test
	void conjuredProductAfterSellInDecreasedQualityDouble() {
		
		Item item = new Item("Conjured Product", 0, 5);

		IProduct conjuredProduct = new ConjuredProductBusiness();
		
		item.sellIn = conjuredProduct.manageSellIn(item.sellIn);
		item = conjuredProduct.manageQuality(item);		

		assertEquals(1, item.quality);
	}
}
