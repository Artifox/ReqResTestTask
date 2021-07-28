package methods.user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import methods.interfaces.IResponse;
import models.request.User;

import static io.restassured.RestAssured.given;

public class PutUserMethod implements IResponse {
    private String url;
    private String userId;
    private User user;

    public PutUserMethod(String url, String userId, User user) {
        this.url = url;
        this.userId = userId;
        this.user = user;
    }

    @Override
    public Response getResponse() {
        Response response =  given().
                contentType(ContentType.JSON).
                body(user).
                log().all().
        when().
                put(url +"/" + userId).
        then().
                log().all().
                statusCode(200).
                contentType(ContentType.JSON).
                extract().response();
        return response;
    }
}
