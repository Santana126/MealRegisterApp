package junit;

import com.example.mealregisterapp.bean.LoginBean;
import com.example.mealregisterapp.exception.EmailFormatException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestEmailFormat {

    /*
        This test verifies that to LOGIN you need to enter an email with a valid syntax
     */

    @Test
    void testValidEmailOnLogin() {
        int validEmail;
        try {
            new LoginBean("gianmarco00", "password");
            validEmail = 1;
        } catch (EmailFormatException e) {
            validEmail = -1;
        }

        //Test fails cause input email was in a wrong format and so the Exception catch turn variable validEmail into -1
        assertEquals(-1, validEmail);
    }

}
