import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class createGroupTest {
    private createGroup payMeApp;

    @BeforeEach
    void setUp() {
        payMeApp = new createGroup();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void displayGroupList() {
        // Add test groups to PayMeApp
        payMeApp.createGroup("Test Group 1", "Details 1");
        payMeApp.createGroup("Test Group 2", "Details 2");

        // Capture the output of displayGroupList
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        payMeApp.displayGroupList();

        String expectedOutput = "Group List:\nTest Group 1\nTest Group 2\n";
        assertEquals(expectedOutput, outputStream.toString());

        System.setOut(System.out);
    }

    @Test
    void createGroup() {
        // Capture the output of createGroup
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        payMeApp.createGroup("Test Group", "Test Details");

        // Verify that the group was created and printed as expected
        String output = outputStream.toString();
        assertTrue(output.contains("Group created successfully!"));
        assertTrue(output.contains("Group Name: Test Group"));
        assertTrue(output.contains("Group Details: Test Details"));
        assertEquals(true, output.contains("Test"));

        System.setOut(System.out);
    }

    @Test
    void setCurrentUser() {
        // Set the current user
        payMeApp.setCurrentUser("TestUser");

        // Verify that the current user has been set correctly
        assertEquals("TestUser", payMeApp.getCurrentUser());
    }
}