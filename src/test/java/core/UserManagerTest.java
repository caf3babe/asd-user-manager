package core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    void compareStringsPositivTest() throws Exception{
        // prepare
        String password_1 ="blA4356";
        String password_2 ="blA4356";

        // execute & check
        assertTrue(InputValidation.compareStrings(password_1,password_2));
    }

    @Test
    void compareStringsNegativTest() throws Exception{
        // prepare
        String password_1 ="blA4356";
        String password_2 ="chrt897";

        // execute & check
        assertFalse(InputValidation.compareStrings(password_1,password_2));

    }

}