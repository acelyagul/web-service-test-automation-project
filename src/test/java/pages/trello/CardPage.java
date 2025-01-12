package pages.trello;

import data.CardTestData;
import models.request.CardRequest;
import models.response.CardResponse;
import services.trello.CardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardPage {
    private CardService cardService;
    
    public CardPage() {
        cardService = new CardService();
    }
    
    public List<CardResponse> createTwoCards(String listId) {
        List<CardResponse> cards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            CardRequest cardRequest = CardTestData.generateCardRequest(listId);
            cards.add(cardService.createCard(cardRequest));
        }
        return cards;
    }
    
    public CardResponse updateRandomCard(List<CardResponse> cards, String listId, String updatedCardName) {
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());
        CardResponse cardToUpdate = cards.get(randomIndex);
        
        CardRequest updateRequest = CardTestData.generateUpdateCardRequest(listId, updatedCardName);
        return cardService.updateCard(cardToUpdate.getId(), updateRequest);
    }
    
    public void deleteCards(List<CardResponse> cards) {
        cards.forEach(card -> cardService.deleteCard(card.getId()));
    }
} 