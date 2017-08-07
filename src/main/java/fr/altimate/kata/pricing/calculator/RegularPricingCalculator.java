package fr.altimate.kata.pricing.calculator;

import java.math.BigDecimal;

import fr.altimate.kata.product.model.Item;

public class RegularPricingCalculator implements PricingCalculator {

	public BigDecimal calculatePrice(Item item) {
		return item.getUnitPrice().multiply(new BigDecimal(item.getQuantity()));
	}
}
