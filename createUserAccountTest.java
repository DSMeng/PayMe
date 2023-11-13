import org.junit.Test;
import static org.junit.Assert.*;

public class createUserAccountTest {

    @Test
    public void testValidPassword() {
        assertTrue(createUserAccount.isValidPassword("Valid@Pass"));
        assertFalse(createUserAccount.isValidPassword("WeakPass"));
    }

    @Test
    public void testValidUsername() {
        assertTrue(createUserAccount.isValidUsername("ValidUser123"));
        assertFalse(createUserAccount.isValidUsername("Short"));
    }

    @Test
    public void testValidName() {
        assertTrue(createUserAccount.isValidName("JohnDoe"));
        assertFalse(createUserAccount.isValidName("A"));
    }


    @Test
    public void testValidThirdPartyKey() {
        assertTrue(createUserAccount.isValidThirdPartyKey("ValidKey123"));
        assertFalse(createUserAccount.isValidThirdPartyKey(""));
    }
}
