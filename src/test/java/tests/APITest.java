package tests;

import adapters.UserAdapter;
import com.github.javafaker.Faker;
import models.request.User;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void userCrud() {
        Faker faker = new Faker();
        User user = User.builder()
                .userName(faker.funnyName().name())
                .jobTitle(faker.job().title())
                .build();

        UserAdapter userAdapter = new UserAdapter();
        String userId = userAdapter.createNewUser(user);
        userAdapter.getUser(userId,200);
        //userAdapter.updateUser();
        //userAdapter.getUser(statusCode);
        //userAdapter.deleteUser();
        //userAdapter.getUser(statusCode);
    }
}
