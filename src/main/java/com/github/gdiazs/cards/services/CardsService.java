package com.github.gdiazs.cards.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.gdiazs.cards.dtos.CardDto;

@Service
public class CardsService {

	private static final List<CardDto> CARDS = new ArrayList<>();

	public void addCard(final CardDto card) {
		CARDS.add(card);
	}

	public List<CardDto> getAllCards() {
		return CARDS;
	}
}
