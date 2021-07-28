package methods.user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import methods.interfaces.IResponse;

import static io.restassured.RestAssured.given;

public class GetUserMethod implements IResponse {
    private String url;
    private String userId;
    int statusCode;

    public GetUserMethod(String url, String userId, int statusCode) {
        this.url = url;
        this.userId = userId;
        this.statusCode = statusCode;
    }

    @Override
    public Response getResponse() {
        Response response = given().
                contentType(ContentType.JSON).
                log().all().
        when().
                get(url + "/" + userId).
        then().
                log().all().
                statusCode(statusCode).
                contentType(ContentType.JSON).
                extract().response();
        return response;
    }
}

