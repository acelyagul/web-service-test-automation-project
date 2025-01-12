package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseHelper {
    protected RequestSpecification spec;
    protected static final String TRELLO_BASE_URL = "https://api.trello.com/1";
    protected static final String BOARDS_PATH = "/boards";
    protected static final String CARDS_PATH = "/cards";
    protected static final String LISTS_PATH = "/lists";
    protected static final String ACTIONS_PATH = "/actions";
    protected static final String MEMBERS_PATH = "/members";
    protected static final String ORGANIZATIONS_PATH = "/organizations";
    
    private static final String TRELLO_API_KEY = "2b1d10226bacb9877838d9344dcc4a01";
    private static final String TRELLO_TOKEN = "ATTAd3586089b4bec7352d71295da6938bded21b51071aa39039e23647f40d763f14883663DF";

    public BaseHelper() {
        spec = new RequestSpecBuilder()
                .setBaseUri(TRELLO_BASE_URL)
                .setContentType(ContentType.JSON)
                .addQueryParam("key", TRELLO_API_KEY)
                .addQueryParam("token", TRELLO_TOKEN)
                .build();
    }

    protected Response sendRequest(Method method, String path, Object body) {
        RequestSpecification request = RestAssured.given(spec)
                .log().all();
        
        if (body != null) {
            request.body(body);
        }
        
        Response response = request.request(method, path);
        response.then().log().all();
        return response;
    }

    protected String buildPath(String... paths) {
        return String.join("/", paths).replaceAll("//", "/");
    }
} 