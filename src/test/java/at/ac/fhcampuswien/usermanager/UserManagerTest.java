package at.ac.fhcampuswien.usermanager;

import at.ac.fhcampuswien.usermanager.exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = UserRepository.class)
@RunWith(MockitoJUnitRunner.class)
class UserManagerTest {

    UserManager userManager;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void init() {
        userManager = new UserManager(userRepository);
    }

    @Test
    void checkIfUserManagerWasInstantiated() {
        assertNotNull(userManager);
    }

    @Test
    void checkIf_checkIfUserNameExists_returnsTrueWhenUserExists() {
        when(userRepository.existsByUsernameEqualsIgnoreCase("ilona"))
                .thenReturn(true);
        String userName = "ilona";
        assertTrue(userManager.doesUserExistWithUserName(userName));
    }

    @Test
    void checkIf_checkIfUserNameExists_returnsFalseWhenUserDoesNotExists() {
        when(userRepository.existsByUsernameEqualsIgnoreCase("ilona"))
                .thenReturn(false);
        String userName = "ilona";
        assertFalse(userManager.doesUserExistWithUserName(userName));
    }

    @Test
    void checkIf_getUserIfExists_ThrowsExceptionWhenUserIsNotFoundInRepository() {
        when(userRepository.getByUsernameEqualsIgnoreCase("aNonExistentUser"))
                .thenReturn(Optional.empty());

        String userName = "aNonExistentUser";
        assertThrows(UserNotFoundException.class, () -> userManager
                .getUserIfExists(userName));
    }

    @Test
    void checkIf_getUserIfExists_returnsUser() {
        when(userRepository.getByUsernameEqualsIgnoreCase("aExistentUser"))
                .thenReturn(Optional.of(new User("aExistentUser",
                        "aExistentUserFirst",
                        "aExistentUserLast",
                        "aExistentUserPass"))
                );

        String userName = "aExistentUser";
        assertDoesNotThrow(() -> userManager.getUserIfExists(userName));
    }

    @Test
    void checkIf_registerUser_doesNotThrowException() {
        assertDoesNotThrow(() -> userManager.registerUser("nichil",
                "Nichil",
                "Strasser",
                "password",
                "password")
        );
    }

    @Test
    void checkIf_registerUser_throwsExceptionWhenUserNameAlreadyExists() {
        when(userRepository.existsByUsernameEqualsIgnoreCase("nichil"))
                .thenReturn(false);
        assertDoesNotThrow(() -> userManager.registerUser("nichil",
                "Nichil",
                "Strasser",
                "password",
                "password")
        );
    }

    @Test
    void checkIf_changePassword_throwsExceptionWhenPasswordsDoNotMatch() {
        String newPassword = "newPassword1!";
        String repeatedNewPassword = "doesNotMatch";

        assertThrows(IllegalArgumentException.class,
                () -> userManager.changePassword(newPassword,
                        repeatedNewPassword),
                "Inputs invalid or do not match!"
        );
    }

    @Test
    void checkIf_login_throwsExceptionAndDecrementsLoginTriesWhenPasswordsDoNotMatch() {
        when(userRepository.getByUsernameEqualsIgnoreCase("nichil"))
                .thenReturn(Optional.of(new User(
                                "nichil",
                                "Nichil",
                                "Strasser",
                                "$2a$12$5Nqzi.6ahnqHfo5XuKs.2.GpvU6sJm1f9W5hs0TJNdKIgoH34zaHW")
                        )
                );


        assertAll(
                () -> {
                    String userName = "nichil";
                    String password = "nichil1!";
                    IllegalArgumentException illegalArgumentException =
                            assertThrows(IllegalArgumentException.class,
                                    () -> userManager.login(userName, password));
                    assertEquals(String.format("Password is not correct. %s tries remaining.",
                                    userManager.getLoginTries()),
                            illegalArgumentException.getMessage());
                },
                () -> {
                    int expectedLoginTries = 1;
                    int actualLoginTries = userManager.getLoginTries();
                    assertEquals(expectedLoginTries, actualLoginTries);
                });


    }

    @Test
    void checkIf_getCurrentUser_throwsExceptionWhenUserNotLoggedIn() {
        assertThrows(UserNotFoundException.class,
                () -> userManager.getCurrentUser());
    }

    @Test
    void checkIf_getCurrentUser_returnsLoggedInUser() throws UserNotFoundException {
        User mockedUser = new User(
                "nichil",
                "Nichil",
                "Strasser",
                "$2a$12$5Nqzi.6ahnqHfo5XuKs.2.GpvU6sJm1f9W5hs0TJNdKIgoH34zaHW");

        when(userRepository.getByUsernameEqualsIgnoreCase("nichil"))
                .thenReturn(Optional.of(mockedUser)
                );

        String userName = "nichil";
        String password = "aPasswordString123";

        userManager.login(userName, password);

        User actualUser = userManager.getCurrentUser();

        assertEquals(mockedUser, actualUser);
    }
}