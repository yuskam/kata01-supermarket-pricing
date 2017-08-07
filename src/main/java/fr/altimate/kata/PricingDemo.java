package fr.altimate.kata;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.altimate.kata.pricing.calculator.PricingCalculator;
import fr.altimate.kata.pricing.calculator.RegularPricingCalculator;
import fr.altimate.kata.product.model.Item;
import fr.altimate.kata.product.model.Product;

@SpringBootApplication
public class PricingDemo {

	public static void main(String[] args) {

		Item item1 = Item.of(new Product().setUnitPrice("3.9")).setQuantity(3);

		Item item2 = Item.of(new Product().setUnitPrice("1.5")).setQuantity(2);

		PricingCalculator pricingStrategy1 = new RegularPricingCalculator();
		PricingCalculator pricingStrategy2 = new RegularPricingCalculator();

		// SpringApplication.run(PricingDemo.class, args);

	}
}
