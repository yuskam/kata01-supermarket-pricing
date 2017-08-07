package fr.altimate.kata.promotion.repository;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import fr.altimate.kata.InMemorySupermarketData;
import fr.altimate.kata.promotion.model.Promotion;

@Repository
public class PromotionReporsitory {
	@Inject
	private InMemorySupermarketData inMemorySupermarketData;

	public List<Promotion> findAvailablePromotions() {
		return inMemorySupermarketData.getPromotions();
	}
}
