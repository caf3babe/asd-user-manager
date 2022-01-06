package at.ac.fhcampuswien.usermanager;

import at.ac.fhcampuswien.usermanager.exceptions.UserNotFoundException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest(classes = UserRepository.class)
@RunWith(MockitoJUnitRunner.class)
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


    @Test
    void getUserIfExists(){
        Mockito
                .when(userRepository.getByUsernameEqualsIgnoreCase("einNichtVorhandenerNameInDerDatenbank"))
                .thenReturn(Optional.empty());

        String userName = "einNichtVorhandenerNameInDerDatenbank";
        assertThrows(UserNotFoundException.class, () -> userManager.getUserIfExists(userName));
    }

    @Test
    void checkIfUserIsCreated_doesNotThrowException(){
        assertDoesNotThrow(() -> userManager.registerUser("nichil", "Nichil", "Strasser", "password", "password"));
    }



}