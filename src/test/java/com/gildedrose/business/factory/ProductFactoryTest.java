package com.gildedrose.business.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.gildedrose.business.IProduct;
import com.gildedrose.business.impl.AgedBrieBusiness;
import com.gildedrose.business.impl.ConjuredProductBusiness;

public class ProductFactoryTest {

	@Test
	public void instanceClassProductOKTest() {

		IProduct product = ProductFactory.get("Conjured Product");
		assertTrue(product instanceof ConjuredProductBusiness);
		
		product = ProductFactory.get("Aged Brie");
		assertTrue(product instanceof AgedBrieBusiness);
	}
}
