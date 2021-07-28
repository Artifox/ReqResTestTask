package methods.user;

import methods.interfaces.IResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.User;
import org.hamcrest.Matcher;

import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class PostUserMethod implements IResponse {
    private String url;
    private User user;

    public PostUserMethod (String url, User user){
        this.url = url;
        this.user = user;
    }

    @Override
    public Response getResponse() {
        return  given().
                contentType(ContentType.JSON).
                body(user).
        when().
                post(url).
        then().
                log().all().
                header("Content-Length", Integer::parseInt, greaterThan(0)).
                statusCode(201).
                contentType(ContentType.JSON).
                assertThat().
                extract().response();
}

}
