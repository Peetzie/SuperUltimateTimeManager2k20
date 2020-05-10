package backend.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.Backend.Main;
import static org.junit.Assert.*;

public class ActivityTestSteps {
    public ActivityTestSteps(){
        Main.setup(this);
        Main.command("signin 0 password");                      //admin login

        Main.command("newemployee password testPM");            //id:1
        Main.command("newemployee password testPBE");           //id:2
        Main.command("newemployee password testE");             //id:3
        Main.command("newemployee password testPBE2");          //id:4

        Main.command("newproject testProject test 10 10");      //id:0
        Main.command("assignpm 0 1");                           //pm asigned
        Main.command("assignemployee 0 2");                     //pbe assigned
        Main.command("assignemployee 0 4");                     //pbe assigned
        Main.command("newactivity 0 testActivity test 10 10");  //id:0

        Main.command("signout");
    }

    @Given("that the current user is an admin")
    public void thatTheCurrentUserIsAnAdmin() {
        Main.command("signin 0 password");
        assertEquals(0,Main.getCurrentUser());
    }

    @Given("that the current user is a project manager")
    public void thatTheCurrentUserIsAProjectManager() {
        Main.command("signin 1 password");
        assertEquals(1,Main.getCurrentUser());
        assertEquals(Main.getEmployees().get(1),Main.getProjects().get(0).getProjectManager());
    }

    @Given("that the current user is a project bound employee")
    public void thatTheEmployeeIsLoggedIn() throws Exception {
        Main.command("signin 2 password");
        assertEquals(2,Main.getCurrentUser());
        assertEquals(true,Main.projectEmployeeRelationExist(0,2));
    }

    @Given("that the current user is an employee")
    public void thatTheCurrentUserIsAnEmployee() {
        Main.command("signin 3 password");
        assertEquals(3,Main.getCurrentUser());
    }

    @And("the user assigns hours")
    public void theUserAssignsHours() {
        Main.command("assignhours 0 10 10");
    }

    @And("the user assigns the activity to project bound employee")
    public void theUserAssignsTheActivityToProjectBoundEmployee() {
        Main.command("assignactivity 0 0 4");
    }

    @And("the user creates a new activity")
    public void theUserCreatesANewActivity() {
        Main.command("newactivity 0 testCreateActivity test 10 10");
    }

    @And("the user edits the hours")
    public void theUserEditsTheHours() {
        Main.command("assignhours 0 10 10");
        Main.command("edithours 0 0 10 5");
    }

    @And("user joins the activity")
    public void userJoinsTheActivity() {
        Main.command("joinactivity 0 0");
    }

    @And("the user removes the activity")
    public void theUserRemovesTheActivity() {
        Main.command("removeactivity 0 0");
    }

    @And("the user sets a deadline for the activity")
    public void theUserSetsADeadlineForTheActivity() {
        Main.command("setactivitydeadline 0 0 5");
    }

    @Then("hours are assigned")
    public void hoursAreAssigned() {
        assertEquals(10, Main.findProjectEmployeeRelation(0, 2).getHours().get(0).getDuration());
    }

    @Then("activity is assigned to project bound employee")
    public void activityIsAssignedToProjectBoundEmployee() {
        assertEquals(1,Main.getProjects().get(0).getActivities().get(0).getEmployees().size());
    }

    @Then("activity is not assigned to project bound employee")
    public void activityIsNotAssignedToProjectBoundEmployee() {
        assertEquals(0,Main.getProjects().get(0).getActivities().get(0).getEmployees().size());
    }

    @Then("new activity in project is created")
    public void newActivityInProjectIsCreated() {
        assertEquals(2,Main.getProjects().get(0).getActivities().size());
    }

    @Then("new activity in project is not created")
    public void newActivityInProjectIsNotCreated() {
        assertEquals(1,Main.getProjects().get(0).getActivities().size());
    }

    @Then("edit is allowed")
    public void editIsAllowed() {
        assertEquals(5,Main.findProjectEmployeeRelation(0,2).getHours().get(0).getDuration());
    }

    @Then("employee joined activity")
    public void employeeJoinedActivity() {
        assertEquals(1,Main.getProjects().get(0).getActivities().get(0).getEmployees().size());
    }

    @Then("employee didnt join activity")
    public void employeeDidntJoinActivity() {
        assertEquals(1,Main.getProjects().get(0).getActivities().get(0).getEmployees().size());
    }

    @Then("activity is removed")
    public void activityIsRemoved() {

        assertTrue(Main.getProjects().get(0).getActivities().get(0).isRemoved());

    }

    @Then("activity is not removed")
    public void activityIsNotRemoved() {
        assertFalse(Main.getProjects().get(0).getActivities().get(0).isRemoved());
    }

    @Then("deadline is added")
    public void deadlineIsAdded() {
        assertEquals(5,Main.getProjects().get(0).getActivities().get(0).getDeadline());
    }

    @Then("deadline is not added")
    public void deadlineIsNotAdded() {
        assertEquals(10,Main.getProjects().get(0).getActivities().get(0).getDeadline());
    }

    @And("user attempts gets help in console")
    public void userAttemptsGetsHelpInConsole() {
        Main.command("help");
    }

    @Then("user gets help in console")
    public void userGetsHelpInConsole() {
        assertEquals(true,Main.command("help"));
    }
}
