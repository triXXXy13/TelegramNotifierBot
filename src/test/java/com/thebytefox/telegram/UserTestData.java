package com.thebytefox.telegram;
import com.thebytefox.telegram.model.Role;
import com.thebytefox.telegram.model.User;
import org.springframework.context.annotation.PropertySource;

import java.util.Set;

import static com.thebytefox.telegram.model.AbstractBaseEntity.START_SEQ;

@PropertySource("classpath:bot/bot.properties")
public class UserTestData {
    public static TestMatcher<User> USER_TEST_MATCHER = TestMatcher.usingFieldsWithIgnoringAssertions(User.class, "schedule");

    public static final int NOT_FOUND = 10;
    public static final int ADMIN_ID = START_SEQ;
    public static final int ADMIN_CHAT_ID = 123456789;

    public static final User ADMIN = new User(ADMIN_ID, ADMIN_CHAT_ID, "me", Set.of(Role.ADMIN), null);
}
