package fr.altimate.kata.product.repository;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import fr.altimate.kata.InMemorySupermarketData;
import fr.altimate.kata.product.model.Item;
import fr.altimate.kata.product.model.ItemPriceInfo;

@Repository
public class ItemPriceInfoRepository {

	@Inject
	private InMemorySupermarketData inMemorySupermarketData;

	public ItemPriceInfo findItemPriceInfo(Item item) {

		List<ItemPriceInfo> itemPricesInfo = inMemorySupermarketData.getItemPricesInfo();

		Optional<ItemPriceInfo> itemPriceInfo = itemPricesInfo.stream()
				.filter((t) -> t.getProduct().getId().equals(item.getProduct().getId()))
				.findFirst();

		return itemPriceInfo.orElse(null);
	}
}
