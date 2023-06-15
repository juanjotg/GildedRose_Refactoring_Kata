package com.gildedrose.business.impl;

import com.gildedrose.business.IProduct;
import com.gildedrose.dto.Item;

/*
 * Artículos conjurados degradan su calidad al doble de velocidad que los normales
 */
public class AgedBrieBusiness implements IProduct {

	@Override
	public int manageSellIn(int sellIn) {

		return 0;
	}

	@Override
	public Item manageQuality(Item item) {

				
		return null;
	}

}
