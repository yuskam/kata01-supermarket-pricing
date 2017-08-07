package fr.altimate.kata.checkout;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.altimate.kata.pricing.ItemPricingEngine;
import fr.altimate.kata.product.model.Item;
import fr.altimate.kata.product.model.Product;

public class CheckoutServiceTest {

	@Mock
	private ItemPricingEngine pricingEngine;

	@InjectMocks
	private CheckoutService checkoutService = new CheckoutService();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCheckout() throws Exception {

		Item item1 = Item.of(new Product().setUnitPrice("1.5")).setQuantity(5);
		Item item2 = Item.of(new Product().setUnitPrice("4.99")).setQuantity(2);

		Mockito.when(pricingEngine.calculatePrice(item1)).thenReturn(new BigDecimal("3.5"));
		Mockito.when(pricingEngine.calculatePrice(item2)).thenReturn(new BigDecimal("6.45"));
		ShoppingCart cart = new ShoppingCart()
				.addItem(item1)
				.addItem(item2);

		BigDecimal totalPrice = checkoutService.checkout(cart);

		Assertions.assertThat(totalPrice).isEqualTo(new BigDecimal("9.95"));

	}

}
