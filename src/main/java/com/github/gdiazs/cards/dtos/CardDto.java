package com.github.gdiazs.cards.dtos;

import javax.validation.constraints.NotBlank;

public class CardDto {

	@NotBlank
	private String cardNumber;

	@NotBlank
	private String cvv;

	@NotBlank
	private String holderName;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

}
