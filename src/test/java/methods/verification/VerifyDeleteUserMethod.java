package methods.verification;

import com.google.gson.Gson;
import io.restassured.response.Response;
import methods.interfaces.IVerifyResponse;
import org.testng.Assert;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class VerifyDeleteUserMethod implements IVerifyResponse {
    Response response;
    public VerifyDeleteUserMethod(Response response) {
        this.response = response;
    }

    @Override
    public void verifyResponse() {
        assertEquals(response.statusCode(), 204, "Status code during deleting is not 204");
        assertThat(response.asString(), is(emptyString()));
    }
}
