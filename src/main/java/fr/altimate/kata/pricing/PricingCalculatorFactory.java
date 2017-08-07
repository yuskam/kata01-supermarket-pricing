package fr.altimate.kata.pricing;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import fr.altimate.kata.pricing.calculator.DiscountableItemPriceCalculator;
import fr.altimate.kata.pricing.calculator.PricingCalculator;
import fr.altimate.kata.pricing.calculator.RegularPricingCalculator;
import fr.altimate.kata.product.model.ItemPriceInfo;
import fr.altimate.kata.promotion.model.DiscountProps;

@Component
public class PricingCalculatorFactory {

	private static final PricingCalculator UNDISCOUNTABLE_ITEM_PRICING_CALCULATOR = new RegularPricingCalculator();

	private Map<DiscountProps, PricingCalculator> pricingCalculatorCache = new HashMap<>();

	public synchronized PricingCalculator getCalculator(ItemPriceInfo itemPriceInfo) {

		if (itemPriceInfo == null) {
			return UNDISCOUNTABLE_ITEM_PRICING_CALCULATOR;
		}

		if (!pricingCalculatorCache.containsKey(itemPriceInfo.getDiscountProps())) {
			pricingCalculatorCache.put(itemPriceInfo.getDiscountProps(), createCalculator(itemPriceInfo));
		}

		return pricingCalculatorCache.get(itemPriceInfo.getDiscountProps());
	}

	public PricingCalculator createCalculator(ItemPriceInfo itemPriceInfo) {
		try {
			Class<?> calculatorClass = Class.forName(itemPriceInfo.getPromotion().getPricingCalculatorId());
			DiscountableItemPriceCalculator pricingCalculator = (DiscountableItemPriceCalculator) calculatorClass.newInstance();
			pricingCalculator.setDiscountProps(itemPriceInfo.getDiscountProps());
			pricingCalculator.afterPropertiesSet();
			return pricingCalculator;
		} catch (Exception e) {
			throw new RuntimeException("Creation bean exception ..");
		}
	}
}
