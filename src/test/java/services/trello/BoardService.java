package services.trello;

import utils.ResponseHelper;
import io.restassured.http.Method;
import io.restassured.response.Response;
import models.request.BoardRequest;
import models.response.BoardResponse;
import utils.BaseHelper;

public class BoardService extends BaseHelper {

    public BoardResponse createBoard(BoardRequest request) {
        Response response = sendRequest(Method.POST, BOARDS_PATH, request);
        ResponseHelper.validateSuccessStatusCode(response);
        return response.as(BoardResponse.class);
    }

    public String getDefaultListId(String boardId) {
        Response response = sendRequest(Method.GET, buildPath(BOARDS_PATH, boardId, "lists"), null);
        ResponseHelper.validateSuccessStatusCode(response);
        return response.jsonPath().getString("[0].id");
    }

    public void deleteBoard(String boardId) {
        Response response = sendRequest(Method.DELETE, buildPath(BOARDS_PATH, boardId), null);
        ResponseHelper.validateSuccessStatusCode(response);
    }
} 