package fr.altimate.kata.pricing.calculator;

import java.math.BigDecimal;

import fr.altimate.kata.product.model.Item;

public class BundlePricingCalculator extends DiscountableItemPriceCalculator {

	@Override
	public BigDecimal calculatePrice(Item item) {
		int bundleCount = item.getQuantity() / discountProps.getQuantity();
		int remainItemCount = item.getQuantity() % discountProps.getQuantity();

		BigDecimal discountPrice = this.discountProps.getPrice().multiply(new BigDecimal(bundleCount));
		BigDecimal regularPrice = item.getUnitPrice().multiply(new BigDecimal(remainItemCount));
		return discountPrice.add(regularPrice);
	}

}
