package com.gildedrose.business.factory;

import com.gildedrose.business.IProduct;
import com.gildedrose.business.impl.AgedBrieBusiness;
import com.gildedrose.business.impl.ConjuredProductBusiness;

public class ProductFactory {

	private ProductFactory() {
	}

	public static IProduct get(String productName) {

		IProduct product = null;

		if ("Conjured Product".equalsIgnoreCase(productName)) {

			product = new ConjuredProductBusiness();
		} 
		
		if ("Aged Brie".equalsIgnoreCase(productName)) {

			product = new AgedBrieBusiness();
		}		

		return product;
	}

}
