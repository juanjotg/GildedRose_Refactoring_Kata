package com.gildedrose.business.impl;

import com.gildedrose.business.IProduct;
import com.gildedrose.dto.Item;

/*
 * Artículos conjurados degradan su calidad al doble de velocidad que los normales
 */
public class ConjuredProductBusiness implements IProduct {

	@Override
	public int manageSellIn(int sellIn) {

		return sellIn - 1;
	}

	@Override
	public Item manageQuality(Item item) {

		if (item.quality > 0) {

			if (item.sellIn < 0) {

				item.quality = item.quality - 4;

			} else {

				item.quality = item.quality - 2;
			}
		}
		
		return item;
	}

}
