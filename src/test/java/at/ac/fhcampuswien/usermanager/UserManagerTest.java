package at.ac.fhcampuswien.usermanager;

import at.ac.fhcampuswien.usermanager.exceptions.UserNotFoundException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UserRepository.class)
class UserManagerTest {

    UserManager userManager;

    @Mock
    UserRepository userRepository;

    @BeforeEach
    void init(){
        userManager = new UserManager(userRepository);
    }

    @Test
    void checkIfUserManagerWasInstantiated(){
        assertNotNull(userManager);
    }

    @Test
    void checkIfUserNameExists(){
        Mockito.when(userRepository.existsByUsernameEqualsIgnoreCase("ilona")).thenReturn(true);
        String userName = "ilona";
        assertTrue(userManager.checkIfUserNameExists(userName));
    }


    // TODO: repair this test case
    void getUserIfExists(){
        Mockito
                .when(userRepository.getByUsernameEqualsIgnoreCase("einNichtVorhandenerNameInDerDatenbank"))
                .thenThrow(new UserNotFoundException("Could not find user in database"));

        String userName = "einNichtVorhandenerNameInDerDatenbank";
        assertThrows(UserNotFoundException.class, () -> userManager.getUserIfExists(userName));
    }

    // TODO: repair this test case
    void checkIfUserIsCreated(){
        User expectedUser = new User("nichil","Nichil", "Strasser", "password");
        Mockito
                .when(userRepository.save(expectedUser))
                .thenReturn(expectedUser);

        userManager.registerUser("nichil", "Nichil", "Strasser", "password", "password");

    }

}