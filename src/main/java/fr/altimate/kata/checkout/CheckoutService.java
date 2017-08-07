package fr.altimate.kata.checkout;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fr.altimate.kata.pricing.ItemPricingEngine;

@Service
public class CheckoutService {

	@Inject
	private ItemPricingEngine itemPricingEngine;

	public BigDecimal checkout(ShoppingCart cart) {

		return cart.getItems()
				.stream()
				.map(item -> itemPricingEngine.calculatePrice(item))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

	}
}
