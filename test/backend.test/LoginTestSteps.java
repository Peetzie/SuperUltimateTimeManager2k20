package backend.test;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Backend.Main;

import static org.junit.Assert.*;


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
        assertEquals(0, Main.getCurrentUser());
    }

    @Then("the employee login fails")
    public void theEmployeeLoginFails() throws Exception {
        assertFalse(Main.command("signin 0 " + password));
    }

    @Then("the employee is not logged in")
    public void theEmployeeIsNotLoggedIn() throws Exception {
        assertEquals(Main.getCurrentUser(), -1);
    }

    @Then("the employee logout suceeds")
    public void theEmployeeLogoutSuceeds() throws Exception {
        assertTrue(Main.command("signout"));
    }


}
