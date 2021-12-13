package at.ac.fhcampuswien.usermanager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

class CustomSpringApplicationContextLoader extends SpringBootContextLoader {

    @Override
    protected SpringApplication getSpringApplication() {
        return new SpringApplicationBuilder().headless(false).build();
    }

}

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = InitGUI.class, loader = CustomSpringApplicationContextLoader.class)
class UserManagerTest {

    @BeforeEach
    void setUp() {
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    void checkIfUserNameExists() {
    }

    @Test
    void getUserIfExists() {
    }

    @Test
    void registerUser() {
    }

    @Test
    void deleteAccount() {
    }

    @Test
    void changePassword() {
    }

    @Test
    void login() {
    }

    @Test
    void logout() {
    }

    @Test
    void getCurrentUser() {
    }

    @Test
    void isUserLoggedIn() {
    }
}
