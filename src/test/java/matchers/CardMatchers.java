package matchers;

import models.response.CardResponse;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class CardMatchers {
    
    public static Matcher<CardResponse> isValidCard() {
        return new TypeSafeMatcher<CardResponse>() {
            @Override
            protected boolean matchesSafely(CardResponse card) {
                return card.getId() != null && !card.getId().isEmpty() &&
                       card.getName() != null && !card.getName().isEmpty() &&
                       card.getIdList() != null && !card.getIdList().isEmpty() &&
                       card.getIdBoard() != null && !card.getIdBoard().isEmpty();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("a valid card with non-null id, name, list id and board id");
            }
        };
    }
    
    public static Matcher<CardResponse> hasCardName(String expectedName) {
        return new TypeSafeMatcher<CardResponse>() {
            @Override
            protected boolean matchesSafely(CardResponse card) {
                return card.getName().equals(expectedName);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("card with name " + expectedName);
            }
        };
    }
    
    public static Matcher<CardResponse> belongsToList(String listId) {
        return new TypeSafeMatcher<CardResponse>() {
            @Override
            protected boolean matchesSafely(CardResponse card) {
                return card.getIdList().equals(listId);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("card belonging to list " + listId);
            }
        };
    }
} 