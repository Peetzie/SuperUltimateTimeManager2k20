package backend.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Backend.Main;

public class EmployeeTestSteps {
    public EmployeeTestSteps(){
        Main.setup(this);
    }
    @Given("that the admin is not logged in")
    public void thatTheAdminIsNotLoggedIn() throws Exception {

    }

    @Then("the admin is logged in")
    public void theAdminIsLoggedIn() throws Exception {
        assertTrue(Main.getCurrentUser() == 0);
    }

    @Then("a new employee exist")
    public void aNewEmployeeExist() throws Exception {
        assertTrue(Main.getEmployees().size() > 1);
    }

    @Then("employee command fails with {string}")
    public void commandFails(String command) throws Exception {
        assertFalse(Main.command(command));
    }

    @Then("employee command suceeds with {string}")
    public void commandSuceeds(String command) throws Exception {
        assertTrue(Main.command(command));
    }
}
