package utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseHelper {
    
    public static void validateStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, 
            "Expected status code: " + expectedStatusCode + " but got: " + response.getStatusCode());
    }
    
    public static void validateSuccessStatusCode(Response response) {
        validateStatusCode(response, 200);
    }
    
    public static void validateCreatedStatusCode(Response response) {
        validateStatusCode(response, 201);
    }
    
    public static void validateNotFoundStatusCode(Response response) {
        validateStatusCode(response, 404);
    }
} 