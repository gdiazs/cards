package com.github.gdiazs.cards.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.gdiazs.cards.dtos.CardDto;
import com.github.gdiazs.cards.services.CardsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/cards/v1")
public class CardsController {

	private final CardsService cardService;

	public CardsController(CardsService cardService) {
		this.cardService = cardService;
	}

	@GetMapping
	@PreAuthorize("hasAuthority('card-read')")
	public ResponseEntity<List<CardDto>> getAll() {

		JwtAuthenticationToken auth = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		log.info("Authenticated user: {}", auth.getToken().getClaim("preferred_username").toString());
		return ResponseEntity.ok(this.cardService.getAllCards());
	}

	@PostMapping
	@PreAuthorize("hasAuthority('card-update')")
	public ResponseEntity<?> addCard(@RequestBody @Validated final CardDto newCard) {
		this.cardService.addCard(newCard);
		return null;
	}

}
