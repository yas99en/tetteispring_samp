package com.example.app;

import java.io.Serializable;
import java.util.List;

public class AccountCreateForm3 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<CardForm> cards;
	
	public List<CardForm> getCards() {
		return cards;
	}
	public void setCards(List<CardForm> cards) {
		this.cards = cards;
	}

	
}
