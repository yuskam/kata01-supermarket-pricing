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
public class BuyNGetOneFreePricingCalculatorTest {
	private static DiscountProps TWO_BOUGHT_ONE_FREE_DISCOUNT;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ 1, "2.50" },
				{ 3, "5.00" },
				{ 7, "12.50" }
		});
	}

	private int quantity;
	private BigDecimal expectedPrice;
	private BuyNGetOneFreePricingCalculator pricingCalculator;

	public BuyNGetOneFreePricingCalculatorTest(int quantity, String calculatedPrice) {
		this.quantity = quantity;
		this.expectedPrice = new BigDecimal(calculatedPrice);
	}

	@BeforeClass
	public static void setDiscount() {
		TWO_BOUGHT_ONE_FREE_DISCOUNT = new DiscountProps();
		TWO_BOUGHT_ONE_FREE_DISCOUNT.put("discount.quantity", 2);
	}

	@Before
	public void setPricingCalculator() {
		pricingCalculator = new BuyNGetOneFreePricingCalculator();
		pricingCalculator.setDiscountProps(TWO_BOUGHT_ONE_FREE_DISCOUNT);
	}

	@Test
	public void testCalculatePrice() throws Exception {
		Item item = Item.of(new Product().setUnitPrice("2.50")).setQuantity(quantity);

		assertThat(pricingCalculator.calculatePrice(item)).isEqualTo(expectedPrice);

	}

}
