package fr.altimate.kata.checkout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.altimate.kata.product.model.Item;

public class ShoppingCart {
	private List<Item> items = new ArrayList<>();

	public ShoppingCart addItem(Item item) {
		items.add(item);
		return this;
	}

	public void items(Item... items) {
		this.items = Arrays.asList(items);
	}

	public List<Item> getItems() {
		return items;
	}
}
