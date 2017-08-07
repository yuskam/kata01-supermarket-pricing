package fr.altimate.kata.product;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fr.altimate.kata.InMemorySupermarketData;
import fr.altimate.kata.product.model.Item;
import fr.altimate.kata.product.model.Product;

@Service
public class ProductService {
	@Inject
	private InMemorySupermarketData inMemorySupermarketData;

	public Item getItem(Long productId, int quantity) {
		Optional<Product> product = inMemorySupermarketData.getProducts()
				.stream()
				.filter(p -> p.getId().equals(productId))
				.findFirst();

		if (!product.isPresent())
			throw new RuntimeException("Product not found");

		return Item.of(product.get()).setQuantity(quantity);
	}
}
