package matchers;

import models.response.BoardResponse;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class BoardMatchers {
    
    public static Matcher<BoardResponse> isValidBoard() {
        return new TypeSafeMatcher<BoardResponse>() {
            @Override
            protected boolean matchesSafely(BoardResponse board) {
                return board.getId() != null && !board.getId().isEmpty() &&
                       board.getName() != null && !board.getName().isEmpty() &&
                       board.getDesc() != null;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("a valid board with non-null id, name and description");
            }
        };
    }
    
    public static Matcher<BoardResponse> hasBoardName(String expectedName) {
        return new TypeSafeMatcher<BoardResponse>() {
            @Override
            protected boolean matchesSafely(BoardResponse board) {
                return board.getName().equals(expectedName);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("board with name " + expectedName);
            }
        };
    }
} 