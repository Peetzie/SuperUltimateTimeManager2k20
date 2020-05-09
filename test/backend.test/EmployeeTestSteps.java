package backend.test;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Backend.Main;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class EmployeeTestSteps {
    public EmployeeTestSteps(){
        Main.setup(this);
        Main.command("signin 0 password");
        Main.command("newemployee pass user");
        Main.command("newemployee pass user2");
    }

    @Given("that the admin is logged in")
    public void thatTheAdminIsLoggedIn() throws Exception {
        assertEquals(0, Main.getCurrentUser());
    }

    @Given("that the employee is not signed in")
    public void thatTheEmployeeIsNotLoggedIn() throws Exception {
        assertEquals(0, Main.getCurrentUser());
    }

    @Then("a new employee exist")
    public void aNewEmployeeExist() throws Exception {
        assertTrue(Main.getEmployees().size() > 3);
    }

    @Then("employee command fails with {string}")
    public void commandFails(String command) throws Exception {
        assertFalse(Main.command(command));
    }

    @Then("admin created new employee")
    public void adminCreatedNewEmployee() throws Exception {
        assertTrue(Main.command("newemployee pass user"));
    }

    @Then("new employee signs in")
    public void newEmployeeSignsIn() throws Exception {
        assertTrue(Main.command("signin 1 pass"));
    }

    @Then("employee created new employee fails")
    public void employeeCreatedNewEmployeeFails() throws Exception {
        assertFalse(Main.command("newemployee pass user2"));
    }

    @Then("admin created new admin")
    public void adminCreatedNewAdmin() throws Exception {
        assertTrue(Main.command("newemployee pass user admin"));
    }

    @Then("a new admin exist")
    public void aNewAdminExist() throws Exception {
        assertTrue(Main.getEmployees().get(3).isAdmin());
    }

    @Then("employee created new admin fails")
    public void employeeCreatedNewAdminFails() throws Exception {
        assertFalse(Main.command("newemployee pass user admin"));
    }

    @Then("admin removes employee suceeds")
    public void adminRemovesEmployeeSuceeds() throws Exception {
        assertTrue(Main.command("removeemployee 1"));
    }

    @Then("a new employee dont exist")
    public void aNewEmployeeDontExist() throws Exception {
        assertTrue(Main.getEmployees().get(1).isRemoved());
        assertFalse(Main.getEmployeesReal().size() > 3);
    }

    @Then("employee removes employee fails")
    public void employeeRemovesEmployeeFails() throws Exception {
        assertFalse(Main.command("removeemployee 2"));
    }

    @Then("admin removes self fails")
    public void adminRemovesSelfFails() throws Exception {
        assertFalse(Main.command("removeemployee 0"));
    }

    @Then("employee removes self fails")
    public void employeeRemovesSelfFails() throws Exception {
        assertFalse(Main.command("removeemployee 1"));
    }

    @Then("the employee signs in")
    public void theEmployeeSignsIn() throws Exception {
        assertTrue(Main.command("signin 1 pass"));
    }
}
