package fr.altimate.kata.promotion.model;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Promotion {
	private Long id;

	private Date creationDate = new Date();

	private String label;

	private Date startDate;
	private Date endDate;

	private String pricingCalculatorId;

	private DiscountProps discountProps;
}
