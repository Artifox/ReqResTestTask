package methods.verification;

import com.google.gson.Gson;
import io.restassured.response.Response;
import methods.interfaces.IVerifyResponse;
import models.request.User;
import models.response.get_single_user.GetSingleUserResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.lessThan;
import static org.testng.Assert.assertEquals;

public class VerifyGetUserMethod implements IVerifyResponse {
    private User user;
    private Response response;
    Gson gson = new Gson();

    public VerifyGetUserMethod(User user, Response response) {
        this.user = user;
        this.response = response;
    }

    @Override
    public void verifyResponse() {
        response.then().assertThat().body(matchesJsonSchemaInClasspath("get_json_schema.json"));
        response.then().time(lessThan(5000L));
        GetSingleUserResponse userResponse = gson.fromJson(response.asString(), GetSingleUserResponse.class);
        assertEquals(userResponse.getData().firstName, user.getUserName(), "Username is not the same as source username");
    }
}
