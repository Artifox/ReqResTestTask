package tests;

import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import methods.user.DeleteUserMethod;
import methods.user.GetUserMethod;
import methods.user.PostUserMethod;
import methods.user.PutUserMethod;
import methods.verification.VerifyDeleteUserMethod;
import methods.verification.VerifyGetUserMethod;
import methods.verification.VerifyPostUserMethod;
import methods.verification.VerifyPutUserMethod;
import models.request.User;
import models.response.PostUserResponse;
import org.testng.annotations.Test;
import utils.UserFactory;

import static org.testng.Assert.assertEquals;

public class UserTest extends BaseTest{
    public static final String URL = "https://reqres.in/api/users";

    @Test
    public void postUserTest() {
        User user = UserFactory.getUser();
        PostUserMethod postUserMethod = new PostUserMethod(URL, user);
        Response response = postUserMethod.getResponse();
        new VerifyPostUserMethod(user, response).verifyResponse();
    }

    @Test
    public void getUserTest() {
        User user = UserFactory.getUser();
        PostUserResponse userResponse = getPostUserResponse(URL, user);
        String userId = userResponse.getId();
        Response response = new GetUserMethod(URL, userId, 200).getResponse();
        new VerifyGetUserMethod(user, response).verifyResponse();
    }

    @Test
    public void putUserTest() {
        User user = UserFactory.getUser();
        PostUserResponse userResponse = getPostUserResponse(URL, user);
        String userId = userResponse.getId();
        user = UserFactory.getUser();
        Response response = new PutUserMethod(URL, userId, user).getResponse();
        new VerifyPutUserMethod(user, response).verifyResponse();
    }

    @Test
    public void deleteUserTest() {
        User user = UserFactory.getUser();
        PostUserResponse userResponse = getPostUserResponse(URL, user);
        String userId = userResponse.getId();
        Response response = new DeleteUserMethod(URL, userId).getResponse();
        new VerifyDeleteUserMethod(response).verifyResponse();
    }

    @Test
    public void e2eUserTest() {
        User user = UserFactory.getUser();
        Response response = new PostUserMethod(URL, user).getResponse();
        String userId = response.as(PostUserResponse.class).getId();
        new PutUserMethod(URL, userId, user).getResponse();
        response = new DeleteUserMethod(URL, userId).getResponse();
        new VerifyDeleteUserMethod(response).verifyResponse();
        new GetUserMethod(URL, userId, 404).getResponse();
    }

    @Test
    public void getUserAsJsonPathTest() {
        Response response = new GetUserMethod(URL, "2", 200).getResponse();
        assertEquals(200, response.getStatusCode());
        String json = response.asString();
        JsonPath jp = new JsonPath(json);
        assertEquals(jp.get("data.email"), "janet.weaver@reqres.in");
        assertEquals(jp.get("data.id").toString(), "2");
        assertEquals(jp.get("data.first_name"), "Janet");
        assertEquals(jp.get("data.last_name"), "Weaver");

    }
}
