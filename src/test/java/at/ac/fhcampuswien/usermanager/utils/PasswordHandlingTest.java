package at.ac.fhcampuswien.usermanager.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordHandlingTest {

    @Test
    void checkIf_hashPassword_hashesPassword(){
        String password = "aPasswordString123";
        String hashedPassword = PasswordHandling.hashPassword(password);
        assertFalse(hashedPassword.equals(password));
    }

    @Test
    void checkIf_checkPassword_throwsIllegalArgumentExceptionWhenSecondArgumentIsNull(){
        String plaintextPassword = "aPassword";

        assertThrows(IllegalArgumentException.class, () -> PasswordHandling.checkPassword(plaintextPassword, null));

    }

    @Test
    void checkIf_checkPassword_throwsIllegalArgumentExceptionWhenSecondArgumentIsNotAValidHash(){
        String plaintextPassword = "aPassword";
        String hashedPassword = "aHashedPassword";
        assertThrows(IllegalArgumentException.class, () -> PasswordHandling.checkPassword(plaintextPassword, hashedPassword));
    }

    @Test
    void checkIf_checkPassword_returnsCorrectCheckingResult(){
        String plaintextPassword = "aPasswordString123";
        String hashedPassword = "$2a$12$5Nqzi.6ahnqHfo5XuKs.2.GpvU6sJm1f9W5hs0TJNdKIgoH34zaHW";
        assertTrue(PasswordHandling.checkPassword(plaintextPassword, hashedPassword));
    }

}