package fr.altimate.kata.pricing.calculator;

import java.util.Objects;

import org.springframework.beans.factory.InitializingBean;

import fr.altimate.kata.promotion.model.DiscountProps;

public abstract class DiscountableItemPriceCalculator implements PricingCalculator, InitializingBean {
	protected DiscountProps discountProps;

	@Override
	public void afterPropertiesSet() throws Exception {
		Objects.requireNonNull(discountProps, "Discount properties must be provided.");
	}

	public void setDiscountProps(DiscountProps discountProps) {
		this.discountProps = discountProps;
	}
}
