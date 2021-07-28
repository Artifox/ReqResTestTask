package methods.user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import methods.interfaces.IResponse;

import static io.restassured.RestAssured.given;

public class DeleteUserMethod implements IResponse {
    String url;
    String userId;

    public DeleteUserMethod(String url, String userId) {
        this.url = url;
        this.userId = userId;
    }

    @Override
    public Response getResponse() {
        Response response = given().
                when().
                        delete(url).
                then().
                        log().all().
                        statusCode(204).
                        extract().response();
        return response;
    }
}
