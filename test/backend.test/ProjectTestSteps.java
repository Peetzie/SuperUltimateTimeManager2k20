package backend.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Backend.Main;

import static org.junit.Assert.*;

public class ProjectTestSteps {

    public ProjectTestSteps(){
        Main.setup(this);
        Main.command("signin 0 password");                      //admin login

        Main.command("newemployee password testPM");            //id:1
        Main.command("newemployee password testPBE");           //id:2
        Main.command("newemployee password testE");             //id:3
        Main.command("newemployee password testPBE2");

        Main.command("newproject testProject test 10 10");      //id:0
        Main.command("assignpm 0 1");                           //pm asigned
        Main.command("assignemployee 0 2");                     //pbe assigned
        Main.command("assignemployee 0 4");                     //pbe assigned
        Main.command("newactivity 0 testActivity test 10 10");  //id:0

        Main.command("signout");
    }

    //@Given("that the current user is an admin")
    public void thatTheCurrentUserIsAnAdmin() throws Exception {
        assertEquals(-1,Main.getCurrentUser());
        Main.command("signin 0 password");
        assertEquals(0,Main.getCurrentUser());
    }


    //@Given("that the current user is a project manager")
    public void thatTheCurrentUserIsAProjectManager() {
        assertEquals(-1,Main.getCurrentUser());
        Main.command("signin 1 password");
        assertEquals(1,Main.getCurrentUser());
    }

    //@Given("current user is Project bound Employee")
    public void currentUserIsProjectBoundEmployee() {
        assertEquals(-1,Main.getCurrentUser());
        Main.command("signin 2 password");
        assertEquals(2,Main.getCurrentUser());
    }

    //@Given("that the current user is an employee")
    public void thatTheCurrentUserIsAnEmployee() {
        assertEquals(-1,Main.getCurrentUser());
        Main.command("signin 3 password");
        assertEquals(3,Main.getCurrentUser());
    }


    @And("an employee exists who isnt a projectmanager")
    public void anEmployeeExistsWhoIsntAProjectmanager() {

    }

    @And("another Employee exists")
    public void anotherEmployeeExists() {
    }


    @Then("user joins project")
    public void userJoinsProject() {
    }

    @And("user is assigned to a project")
    public void userIsAssignedToAProject() {
    }

    @Then("user leaves project")
    public void userLeavesProject() {
    }

    @Then("user removes employee from project")
    public void userRemovesEmployeeFromProject() {

    }


    @And("a project exists")
    public void aProjectExists() {
    }

    @And("another project exists")
    public void anotherProjectExists() {
    }

    @And("a project with atleast one employee exists")
    public void aProjectWithAtleastOneEmployeeExists() {
    }

    @And("a project exists with a projectmanager")
    public void aProjectExistsWithAProjectmanager() {
    }

    @And("an unmanaged Project Exists")
    public void anUnmanagedProjectExists() {
    }


    @Then("user gets the project information")
    public void userGetsTheProjectInformation() {
    }

    @And("current project has no project manager")
    public void projectHasNoProjectManager() {
    }


    @Then("user assigns a new employee to the project")
    public void userAssignsANewEmployeeToTheProject() {
    }

    @Then("user fails to assign a new employee to the project")
    public void userFailsToAssignANewEmployeeToTheProject() {
    }


    @Then("user assigns a new project manager to the project")
    public void userAssignsANewProjectManagerToTheProject() {
    }

    @Then("user fails to assign a new project manager to the project")
    public void userFailsToAssignANewProjectManagerToTheProject() {
    }


    @Then("user creates new project")
    public void userCreatesNewProject() {
    }

    @Then("user fails to create new project")
    public void userFailsToCreateNewProject() {
    }

    @Then("current user assigns a new projectmanager to the unmanaged project")
    public void currentUserAssignsANewProjectmanagerToTheUnmanagedProject() {
    }

    @Then("current user fails to assigns a new projectmanager to the unmanaged project")
    public void currentUserFailsToAssignsANewProjectmanagerToTheUnmanagedProject() {
    }

    @And("current user assigns a new projectmanager to new project")
    public void userAssignsProjectToNewProject() {
    }


    @Then("user changes the status of the project")
    public void userChangesTheStatusOfTheProject() {
    }

    @Then("user fails to change the status of the project")
    public void userFailsToChangeTheStatusOfTheProject() {
    }

    @Then("user deletes the project")
    public void userDeletesTheProject() {
    }

    @Then("user fails to delete the project")
    public void userFailsToDeleteTheProject() {
    }


}
