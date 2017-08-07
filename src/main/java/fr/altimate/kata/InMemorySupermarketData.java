package fr.altimate.kata;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import fr.altimate.kata.pricing.calculator.BundlePricingCalculator;
import fr.altimate.kata.pricing.calculator.BuyNGetOneFreePricingCalculator;
import fr.altimate.kata.product.model.ItemPriceInfo;
import fr.altimate.kata.product.model.Product;
import fr.altimate.kata.promotion.model.DiscountProps;
import fr.altimate.kata.promotion.model.Promotion;

@Component
public class InMemorySupermarketData {

	private List<Promotion> promotions = new ArrayList<>();

	private List<Product> products = new ArrayList<>();

	private List<ItemPriceInfo> itemPricesInfo = new ArrayList<>();

	@PostConstruct
	public void init() {

		// Products

		Product product1 = new Product().setId(1L).setName("Volvic").setUnitPrice("2.99");
		Product product2 = new Product().setId(2L).setName("Kit Kat").setUnitPrice("2.50");
		Product product3 = new Product().setId(3L).setName("Candy").setUnitPrice("0.50");
		// Non discountable Porduct
		Product product4 = new Product().setId(4L).setName("Milk Candia").setUnitPrice("1.30");

		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);

		// Promotions

		Promotion promotion1 = new Promotion().setLabel("Buy Two Get One Free Discount")
				.setPricingCalculatorId(BuyNGetOneFreePricingCalculator.class.getCanonicalName())
				.setDiscountProps(new DiscountProps().setQuantity(2));

		Promotion promotion2 = new Promotion().setLabel("Three For One Euro Discount")
				.setPricingCalculatorId(BundlePricingCalculator.class.getCanonicalName())
				.setDiscountProps(new DiscountProps().setQuantity(3).setPrice("1"));

		promotions.add(promotion1);
		promotions.add(promotion2);

		// Item Prices Info
		ItemPriceInfo itemPriceInfo1 = new ItemPriceInfo().setProduct(product1).setPromotion(promotion1);
		ItemPriceInfo itemPriceInfo2 = new ItemPriceInfo().setProduct(product2).setPromotion(promotion1);
		ItemPriceInfo itemPriceInfo3 = new ItemPriceInfo().setProduct(product3).setPromotion(promotion2);

		itemPricesInfo.add(itemPriceInfo1);
		itemPricesInfo.add(itemPriceInfo2);
		itemPricesInfo.add(itemPriceInfo3);

	}

	public List<Product> getProducts() {
		return products;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public List<ItemPriceInfo> getItemPricesInfo() {
		return itemPricesInfo;
	}
}
