package fr.altimate.kata.promotion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Properties;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class DiscountProps implements Serializable {
	private static final long serialVersionUID = 1L;

	private String calculatorId;
	private Properties props = new Properties();

	public int getInt(String criterion) {
		return (Integer) props.getOrDefault(criterion, 0);
	}

	public int getQuantity() {
		return (Integer) props.getOrDefault("discount.quantity", 0);
	}

	public BigDecimal getPrice() {
		return (BigDecimal) props.getOrDefault("discount.price", BigDecimal.ZERO);
	}

	public String getCalculatorId() {
		return calculatorId;
	}

	public void setCalculatorId(String calculatorId) {
		this.calculatorId = calculatorId;
	}

	public void put(Object key, Object value) {
		props.put(key, value);
	}

	public DiscountProps setQuantity(int quantity) {
		props.put("discount.quantity", quantity);
		return this;
	}

	public DiscountProps setPrice(String price) {
		props.put("discount.price", new BigDecimal(price));
		return this;
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof DiscountProps))
			return false;

		DiscountProps other = (DiscountProps) obj;
		return new EqualsBuilder()
				.append(getCalculatorId(), other.getCalculatorId())
				.append(props, other.props)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(11, 17)
				.append(getCalculatorId())
				.append(props)
				.toHashCode();
	}
}
