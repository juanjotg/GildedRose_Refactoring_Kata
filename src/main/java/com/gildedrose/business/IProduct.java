package com.gildedrose.business;

import com.gildedrose.dto.Item;

public interface IProduct {
	
	int manageSellIn(int sellIn);
	
	Item manageQuality(Item item);

}
