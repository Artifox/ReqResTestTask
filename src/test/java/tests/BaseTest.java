package tests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import methods.user.PostUserMethod;
import models.request.User;
import models.response.PostUserResponse;

public class BaseTest {
    Gson gson = new Gson();
    public PostUserResponse getPostUserResponse(String url, User user){
        Response response = new PostUserMethod(url, user).getResponse();
        PostUserResponse userResponse = gson.fromJson(response.asString(), PostUserResponse.class);
        return userResponse;
    }
}
