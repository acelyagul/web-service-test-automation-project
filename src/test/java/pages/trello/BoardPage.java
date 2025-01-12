package pages.trello;

import data.BoardTestData;
import models.request.BoardRequest;
import models.response.BoardResponse;
import services.trello.BoardService;

public class BoardPage {
    private BoardService boardService;
    
    public BoardPage() {
        boardService = new BoardService();
    }
    
    public BoardResponse createBoard() {
        BoardRequest boardRequest = BoardTestData.generateBoardRequest();
        return boardService.createBoard(boardRequest);
    }
    
    public String getDefaultListId(String boardId) {
        return boardService.getDefaultListId(boardId);
    }
    
    public void deleteBoard(String boardId) {
        boardService.deleteBoard(boardId);
    }
} 