package methods.verification;

import com.google.gson.Gson;
import io.restassured.response.Response;
import methods.interfaces.IVerifyResponse;
import models.request.User;
import models.response.PostUserResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class VerifyPostUserMethod implements IVerifyResponse {
    private User user;
    private Response response;

    public VerifyPostUserMethod(User user, Response response) {
        this.user = user;
        this.response = response;
    }

    @Override
    public void verifyResponse() {
        Gson gson = new Gson();
        PostUserResponse userResponse = gson.fromJson(response.asString(), PostUserResponse.class);
        assertEquals(userResponse.getUserName(), user.getUserName(), "Username is not the same as source username");
        assertEquals(userResponse.getJobTitle(), user.getJobTitle(), "Job title is not the same as source job title");

    }
}
