package fr.altimate.kata.checkout;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.altimate.kata.product.ProductService;
import fr.altimate.kata.product.model.Item;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckoutServiceIT {

	@Inject
	private CheckoutService checkoutService;

	@Inject
	private ProductService productService;

	@Test
	public void testCheckout() {

		Item item1 = productService.getItem(1L, 5); // unit Price 2.99 ;
													// BuyTwoGetOne
		Item item2 = productService.getItem(2L, 7); // 2.50 ; BuyTwoGetOne
		Item item3 = productService.getItem(3L, 4); // 0.50; Three For 1 euro

		Item item4 = productService.getItem(4L, 6); // 1.30; Non discountable
		ShoppingCart shoppingCart = new ShoppingCart()
				.addItem(item1)
				.addItem(item2)
				.addItem(item3)
				.addItem(item4);

		BigDecimal totalPrice = checkoutService.checkout(shoppingCart);
		Assertions.assertThat(totalPrice).isEqualTo(new BigDecimal("33.76"));

	}
}
