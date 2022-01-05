package at.ac.fhcampuswien.usermanager.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InputValidationTest {


    @Test
    void checkIfThrowsExceptionWhenStringIsNull() {
        String value1 = "";
        String value2 = "";

        assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.compareStrings(value1, value2);
        });
    }

    @Test
    void checkIfEqualStringsReturnTrue_compareStrings(){
        String value1 = "securePassword12#!";
        String value2 = "securePassword12#!";

        assertTrue(InputValidation.compareStrings(value1, value2));
    }

    @Test
    void checkIf_passwordValidation_ThrowsErrorWhenPasswordIsTooLong(){
        String password = "SuperSecure1!";
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidation.passwordValidation(password);
        });
    }

    @Test
    void checkIf_passwordValidation_DoesNotThrowWhenPasswordIsSecure(){
        String password = "SuperSec11";
        assertDoesNotThrow(() -> {
            InputValidation.passwordValidation(password);
        });
    }
}
