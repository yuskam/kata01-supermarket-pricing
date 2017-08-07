package fr.altimate.kata.pricing.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import fr.altimate.kata.product.model.Item;

public class BuyNGetOneFreePricingCalculator extends DiscountableItemPriceCalculator {

	@Override
	public BigDecimal calculatePrice(Item item) {

		int promotionalQuantity = (int) (item.getQuantity() / (discountProps.getQuantity() + 1));
		int regularQuantity = item.getQuantity() % (discountProps.getQuantity() + 1);

		return item.getUnitPrice().multiply(new BigDecimal(promotionalQuantity * discountProps.getQuantity() + regularQuantity))
				.setScale(2, RoundingMode.HALF_UP);

	}

}
