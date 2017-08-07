package fr.altimate.kata.product.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Item {

	private Product product;
	private int quantity;

	public static Item of(Product product) {
		return new Item().setProduct(product);
	}

	public BigDecimal getUnitPrice() {
		return product.getUnitPrice();
	}

}
