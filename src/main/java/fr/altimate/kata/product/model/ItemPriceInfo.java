package fr.altimate.kata.product.model;

import lombok.Data;
import lombok.experimental.Accessors;
import fr.altimate.kata.promotion.model.DiscountProps;
import fr.altimate.kata.promotion.model.Promotion;

@Data
@Accessors(chain = true)
public class ItemPriceInfo {
	private Long id;

	private Product product;
	private Promotion promotion;

	public DiscountProps getDiscountProps() {
		return promotion.getDiscountProps();
	}
}
