package data;

import com.github.javafaker.Faker;

import models.request.BoardRequest;

public class BoardTestData {
        private static final Faker faker = new Faker();
    
    public static BoardRequest generateBoardRequest() {
        return BoardRequest.builder()
                .name(faker.company().buzzword() + " Board")
                .desc(faker.lorem().paragraph())
                .defaultLists("true")
                .prefs_permissionLevel("private")
                .build();
    }
}
