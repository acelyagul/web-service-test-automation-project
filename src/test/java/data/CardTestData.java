package data;

import com.github.javafaker.Faker;
import models.request.CardRequest;

public class CardTestData {
    private static final Faker faker = new Faker();

    
    public static CardRequest generateCardRequest(String listId) {
        return CardRequest.builder()
                .name(faker.commerce().productName())
                .desc(faker.lorem().sentence())
                .idList(listId)
                .build();
    }
    
    public static CardRequest generateUpdateCardRequest(String listId, String cardName) {
        return CardRequest.builder()
                .name(cardName)
                .desc(faker.lorem().paragraph(2))
                .idList(listId)
                .build();
    }
    
} 