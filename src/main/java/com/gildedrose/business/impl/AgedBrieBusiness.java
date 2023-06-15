package com.gildedrose.business.impl;

import com.gildedrose.business.IProduct;
import com.gildedrose.dto.Item;

/*
 * Artículos conjurados degradan su calidad al doble de velocidad que los normales
 */
public class AgedBrieBusiness implements IProduct {

	@Override
	public int manageSellIn(int sellIn) {

		return sellIn - 1;
	}

	@Override
	public Item manageQuality(Item item) {
				
		if (item.quality < 50) {
			
			if (item.sellIn < 0) {

				item.quality = item.quality + 2;

			} else {

				item.quality = item.quality + 1;
			}			            
		}
		
		return item;
	}

}
