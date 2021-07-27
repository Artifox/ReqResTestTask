package adapters;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import models.request.User;
import models.response.UserResponse;
import models.response.single_user.SingleUserResponse;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class UserAdapter {
    Gson gson = new Gson();
    public static final String URL = "https://reqres.in/api/users";

    //@formatter:off
    public String createNewUser(User user){
        String response =  given().
                contentType(ContentType.JSON).
                body(user).
        when().
                post(URL).
        then().
                log().all().
                statusCode(201).
                contentType(ContentType.JSON).
                extract().body().asString();
        UserResponse userResponse = gson.fromJson(response, UserResponse.class);
        Assert.assertEquals(userResponse.getUserName(), user.getUserName(), "Username is not the same as source username");
        Assert.assertEquals(userResponse.getJobName(), user.getJobTitle(), "Job title is not the same as source job title");
        return userResponse.getId();
    }
    //@formatter:on

    public String getUser(String userId, int statusCode) {
        String response = given().
                contentType(ContentType.JSON).
                log().all().
        when().
                get(URL + "/" + userId).
        then().
                log().all().
                statusCode(statusCode).
                contentType(ContentType.JSON).
                extract().body().asString();
        SingleUserResponse singleUserResponse = gson.fromJson(response, SingleUserResponse.class);
        Assert.assertEquals(singleUserResponse.getData().id, userId, "User id is not the same as source id");
        return response;
    }
}
