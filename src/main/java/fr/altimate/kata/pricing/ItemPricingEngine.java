package fr.altimate.kata.pricing;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import fr.altimate.kata.pricing.calculator.PricingCalculator;
import fr.altimate.kata.product.model.Item;
import fr.altimate.kata.product.model.ItemPriceInfo;
import fr.altimate.kata.product.repository.ItemPriceInfoRepository;

@Component
public class ItemPricingEngine {

	@Inject
	private PricingCalculatorFactory pricingCalculatorFactory;

	@Inject
	private ItemPriceInfoRepository itemPriceInfoRepository;

	public BigDecimal calculatePrice(Item item) {
		ItemPriceInfo itemPriceInfo = itemPriceInfoRepository.findItemPriceInfo(item);

		PricingCalculator pricingCalculator = pricingCalculatorFactory.getCalculator(itemPriceInfo);

		return pricingCalculator.calculatePrice(item);
	}

}
