package backend.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Backend.Main;



public class LoginTestSteps {

    private String password;

    public LoginTestSteps() {
        Main.setup(this);
    }

    @Given("that the employee is not logged in")
    public void thatTheEmployeeIsNotLoggedIn() throws Exception {
        assertFalse(Main.getCurrentUser() == 0);
    }

    @Given("the password is {string}")
    public void thePasswordIs(String password) throws Exception {
        this.password = password;
    }

    @Then("the employee login suceeds")
    public void theEmployeeLoginSuceeds() throws Exception {
        assertTrue(Main.command("signin 0 " + password));
    }

    @Then("the employee is logged in")
    public void theEmployeeIsLoggedIn() throws Exception {
        assertTrue(Main.getCurrentUser() == 0);
    }

    @Then("the employee login fails")
    public void theEmployeeLoginFails() throws Exception {
        assertFalse(Main.command("signin 0 " + password));
    }

    @Then("the employee is not logged in")
    public void theEmployeeIsNotLoggedIn() throws Exception {
        assertTrue(Main.getCurrentUser() == -1);
    }


}
