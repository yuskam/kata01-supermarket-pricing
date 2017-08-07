package fr.altimate.kata.pricing.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.altimate.kata.product.model.Item;
import fr.altimate.kata.product.model.Product;
import fr.altimate.kata.promotion.model.DiscountProps;

@RunWith(Parameterized.class)
public class BundlePricingCalculatorTest {
	private static DiscountProps THREE_FOR_ONE_EURO_DISCOUNT;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 1, "0.50" },
				{ 2, "1.00" },
				{ 3, "1.00" },
				{ 5, "2.00" },
				{ 7, "2.50" }
		});
	}

	private int quantity;
	private BigDecimal expectedPrice;

	private BundlePricingCalculator bundlePricingCalculator;

	public BundlePricingCalculatorTest(int quantity, String calculatedPrice) {
		this.quantity = quantity;
		this.expectedPrice = new BigDecimal(calculatedPrice);
	}

	@BeforeClass
	public static void setDiscount() {
		THREE_FOR_ONE_EURO_DISCOUNT = new DiscountProps();
		THREE_FOR_ONE_EURO_DISCOUNT.put("discount.quantity", 3);
		THREE_FOR_ONE_EURO_DISCOUNT.put("discount.price", new BigDecimal(1));
	}

	@Before
	public void setPricingCalculator() {
		bundlePricingCalculator = new BundlePricingCalculator();
		bundlePricingCalculator.setDiscountProps(THREE_FOR_ONE_EURO_DISCOUNT);
	}

	@Test
	public void testCalculatePrice() throws Exception {
		Item item = Item.of(new Product().setUnitPrice("0.50")).setQuantity(quantity);

		assertThat(bundlePricingCalculator.calculatePrice(item)).isEqualTo(expectedPrice);

	}

}
