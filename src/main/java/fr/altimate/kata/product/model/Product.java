package fr.altimate.kata.product.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class Product {
	private Long id;

	private Date creationDate = new Date();

	private String name;
	private String brand;

	private BigDecimal unitPrice;

	public Product setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = new BigDecimal(unitPrice.doubleValue());
		return this;
	}

	public Product setUnitPrice(String unitPrice) {
		this.unitPrice = new BigDecimal(unitPrice);
		return this;
	}
}
