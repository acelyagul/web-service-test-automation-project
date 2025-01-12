package tests.trello;

import matchers.BoardMatchers;
import matchers.CardMatchers;
import models.response.BoardResponse;
import models.response.CardResponse;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;

public class TrelloBoardTest extends BaseTest {

    @Test
    public void shouldPerformTrelloBoardOperations() {

        BoardResponse board = boardPage.createBoard();
        assertThat(board, allOf(
            BoardMatchers.isValidBoard(),
            BoardMatchers.hasBoardName(board.getName())
        ));
        
        String defaultListId = boardPage.getDefaultListId(board.getId());
        
        List<CardResponse> cards = cardPage.createTwoCards(defaultListId);
        cards.forEach(card -> {
            assertThat(card, CardMatchers.isValidCard());
            assertThat(card, CardMatchers.belongsToList(defaultListId));
        });
        
        String updatedCardName = "Updated: " + cards.get(0).getName(); 
        CardResponse updatedCard = cardPage.updateRandomCard(cards, defaultListId, updatedCardName);
        assertThat(updatedCard, CardMatchers.isValidCard());
        assertThat(updatedCard, CardMatchers.hasCardName(updatedCardName));
        
        cardPage.deleteCards(cards);
        
        boardPage.deleteBoard(board.getId());
    }
} 