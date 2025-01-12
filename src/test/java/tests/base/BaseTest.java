package tests.base;

import pages.trello.BoardPage;
import pages.trello.CardPage;

public class BaseTest {
    protected BoardPage boardPage;
    protected CardPage cardPage;
    
    public BaseTest() {
        boardPage = new BoardPage();
        cardPage = new CardPage();
    }
} 