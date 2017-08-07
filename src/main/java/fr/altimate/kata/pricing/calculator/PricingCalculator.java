package fr.altimate.kata.pricing.calculator;

import java.math.BigDecimal;

import fr.altimate.kata.product.model.Item;

public interface PricingCalculator {

	public abstract BigDecimal calculatePrice(Item item);

}
