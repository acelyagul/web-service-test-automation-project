package services.trello;

import utils.ResponseHelper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import models.request.CardRequest;
import models.response.CardResponse;
import utils.BaseHelper;

public class CardService extends BaseHelper {

    public CardResponse createCard(CardRequest request) {
        Response response = sendRequest(Method.POST, CARDS_PATH, request);
        ResponseHelper.validateSuccessStatusCode(response);
        return response.as(CardResponse.class);
    }

    public CardResponse updateCard(String cardId, CardRequest request) {
        Response response = sendRequest(Method.PUT, buildPath(CARDS_PATH, cardId), request);
        ResponseHelper.validateSuccessStatusCode(response);
        return response.as(CardResponse.class);
    }

    public void deleteCard(String cardId) {
        Response response = sendRequest(Method.DELETE, buildPath(CARDS_PATH, cardId), null);
        ResponseHelper.validateSuccessStatusCode(response);
    }
} 