package utils;

import com.github.javafaker.Faker;
import models.request.User;

public class UserFactory {

    public static User getUser() {
        Faker faker = new Faker();
        User user = User.builder()
                .userName(faker.funnyName().name())
                .jobTitle(faker.job().title())
                .build();
        return user;
    }
}
