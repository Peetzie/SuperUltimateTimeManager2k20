package backend.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Backend.Main;

import static org.junit.Assert.*;

public class ProjectTestSteps {

    public ProjectTestSteps(){

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

    @And("user attempts to assign a new employee to the project")
    public void userAttemptsToAssignANewEmployeeToTheProject() {
        Main.command("assignemployee 0 3");
    }

    @Then("new employee is bound to the project")
    public void newEmployeeIsBoundToTheProject() {
        assertEquals(true,Main.projectEmployeeRelationExist(0,3));
    }

    @Then("new employee is not bound to the project")
    public void newEmployeeIsNotBoundToTheProject() {
        assertEquals(false,Main.projectEmployeeRelationExist(0,3));
    }

    @And("a project exists with a project manager")
    public void aProjectExistsWithAProjectManager() {
        assertEquals(true,Main.getProjects().get(0).hasProjectManager());
    }

    @And("user attempts to assign a new project manager to the project")
    public void userAttemptsToAssignANewProjectManagerToTheProject() {
        Main.command("assignpm 0 2");
    }

    @Then("new project manager is assigned to the project")
    public void newProjectManagerIsAssignedToTheProject() {
        assertEquals(Main.getEmployees().get(2),Main.getProjects().get(0).getProjectManager());
    }

    @And("current user is no longer project manager for the project")
    public void currentUserIsNoLongerProjectManagerForTheProject() {
        assertNotEquals(Main.getCurrentUser(),Main.getProjects().get(0).getProjectManager());
    }

    @Then("new project manager not is assigned to the project")
    public void newProjectManagerNotIsAssignedToTheProject() {
        assertNotEquals(Main.getEmployees().get(2),Main.getProjects().get(0).getProjectManager());
    }

    @And("an unmanaged project Exists")
    public void anUnmanagedProjectExists() {
        int current = Main.getCurrentUser();
        Main.command("signout");
        Main.command("signin 0 password");
        Main.command("newproject testProject1 test 10 10");
        assertEquals(2,Main.getProjects().size());
        Main.command("signout");
        Main.command("signin "+current+" password");
    }

    @And("another employee exists")
    public void anotherEmployeeExists() {
        assertNotEquals(1,Main.getEmployees().size());
    }

    @And("user attempts to assign a new project manager to the unmanaged project")
    public void userAttemptsToAssignANewProjectManagerToTheUnmanagedProject() {
        Main.command("assignpm 1 2");
    }

    @Then("A new project manager is assigned to the project")
    public void aNewProjectManagerIsAssignedToTheProject() {
        assertEquals(true,Main.getProjects().get(1).hasProjectManager());
    }

    @Then("A new project manager is not assigned to the project")
    public void aNewProjectManagerIsNotAssignedToTheProject() {
        assertEquals(false,Main.getProjects().get(1).hasProjectManager());
    }

    @And("user attempts to change the status of the project")
    public void userAttemptsToChangeTheStatusOfTheProject() {
        Main.command("setstatus 0 1");
    }

    @Then("the status of the project is changed")
    public void theStatusOfTheProjectIsChanged() {
        assertEquals(1,Main.getProjects().get(0).getStatus());
    }

    @Then("the status of the project is not changed")
    public void theStatusOfTheProjectIsNotChanged() {
        assertEquals(0,Main.getProjects().get(0).getStatus());
    }

    @And("user attempts to create new project, with a project manager")
    public void userAttemptsToCreateNewProjectWithAProjectManager() {
        Main.command("newproject testProject1 test 10 10");
        if (Main.getProjects().size() == 2) {
            Main.command("assignpm 1 3");
        }
    }

    @Then("current project is created and has a project manager")
    public void currentProjectIsCreatedAndHasAProjectManager() {
        assertEquals(true,Main.getProjects().get(1).hasProjectManager());
    }

    @Then("current project is not created")
    public void currentProjectIsNotCreatedAndDoesNotProjectManager() {
        assertEquals(false,Main.getProjects().contains(1));
    }

    @And("user attempts to create new project")
    public void userAttemptsToCreateNewProject() {
        Main.command("newproject testProject1 test 10 10");
    }

    @Then("New project is created and has no project manager")
    public void newProjectIsCreatedAndHasNoProjectManager() {
        assertEquals(false, Main.getProjects().get(1).hasProjectManager());
    }

    @Then("New project is not created")
    public void newProjectIsNotCreatedAndHasNoProjectManager() {
        assertEquals(1,Main.getProjects().size());
    }

    @And("a project exists")
    public void aProjectExists() {
        assertNotEquals(0,Main.getProjects().size());
    }

    @And("user attempts to delete the project")
    public void userAttemptsToDeleteTheProject() {
        Main.command("removeproject 0");
    }

    @Then("project is marked as removed")
    public void projectIsMarkedAsRemoved() {
        assertTrue(Main.getProjects().get(0).isRemoved());
    }

    @Then("project is not marked as removed")
    public void projectIsNotMarkedAsRemoved() {
        assertFalse(Main.getProjects().get(0).isRemoved());
    }

    @And("user attempts to get the project information")
    public void userAttemptsToGetTheProjectInformation() {
        Main.command("getprojectinfo 0");
    }

    @Then("user gets information")
    public void userGetsInformation() {
        assertTrue(Main.command("getprojectinfo 0"));
    }

    @And("another project exists")
    public void anotherProjectExists() {
        int current = Main.getCurrentUser();
        Main.command("signout");
        Main.command("signin 0 password");
        Main.command("newproject testProject1 test 10 10");
        assertEquals(2,Main.getProjects().size());
        Main.command("signout");
        Main.command("signin "+current+" password");
    }

    @And("user attempts to joins project")
    public void userAttemptsToJoinsProject() {
        Main.command("joinproject 1");
    }

    @Then("user has joined project")
    public void userHasJoinedProject() {
        assertEquals(true,Main.projectEmployeeRelationExist(1, Main.getCurrentUser()));
    }

    @And("user is assigned to a project")
    public void userIsAssignedToAProject() {
        assertEquals(true,Main.projectEmployeeRelationExist(0, Main.getCurrentUser()));

    }

    @And("user attempts to leaves project")
    public void userAttemptsToLeavesProject() {
        Main.command("leaveproject 0");
    }

    @Then("user has left project")
    public void userHasLeftProject() {
        assertEquals(false,Main.projectEmployeeRelationExist(0, Main.getCurrentUser()));
    }

    @And("a project with atleast one employee exists")
    public void aProjectWithAtleastOneEmployeeExists() {
        assertNotEquals(0,Main.getProjects().get(0).getEmployeeRelations().size());
    }



    @And("user attempts to set deadline")
    public void userAttemptsToSetDeadline() {
        Main.command("setdeadline 0 5");
    }

    @Then("project deadline is set")
    public void projectDeadlineIsSet() {
        assertEquals(5,Main.getProjects().get(0).getDeadline());
    }

    @Then("project deadline is not set")
    public void projectDeadlineIsNotSet() {
        assertEquals(10,Main.getProjects().get(0).getDeadline());
    }

    @And("an activity exists")
    public void anActivityExists() {
        assertNotEquals(0,Main.getProjects().get(0).getActivities().size());
    }

    @And("user attempts to set activity status")
    public void userAttemptsToSetActivityStatus() {
        Main.command("setactivitystatus 0 0 1");
    }

    @Then("activity status is set")
    public void activityStatusIsSet() {
        assertEquals(1,Main.getProjects().get(0).getActivities().get(0).getStatus());
    }

    @Then("activity status is not set")
    public void activityStatusIsNotSet() {
        assertNotEquals(1,Main.getProjects().get(0).getActivities().get(0).getStatus());
    }

    @And("user attempts to assign employee hours")
    public void userAttemptsToAssignEmployeeHours() {
        Main.command("assignemployeehours 0 4 10 10");
    }

    @Then("user assigns employee hours")
    public void userAssignsEmployeeHours() {
        assertEquals(1,Main.getEmployees().get(4).getProjectRelations().get(0).getHours().size());
    }

    @Then("user does not assigns employee hours")
    public void userDoesNotAssignsEmployeeHours() {
        assertNotEquals(1,Main.getEmployees().get(4).getProjectRelations().get(0).getHours().size());
    }

    @And("user attempts to edits employee hours")
    public void userAttemptsToEditsEmployeeHours() {
        Main.command("editemployeehours 0 4 0 5 5");
    }

    @Then("user edits employee hours")
    public void userEditsEmployeeHours() {
        assertEquals(5,Main.getEmployees().get(4).getProjectRelations().get(0).getHours().get(0).getDuration());

    }

    @Then("user does not edits employee hours")
    public void userDoesNotEditsEmployeeHours() {
        assertNotEquals(5,Main.getEmployees().get(4).getProjectRelations().get(0).getHours().get(0).getDuration());
    }

    @And("employee has assigned employee hours")
    public void employeeHasAssignedEmployeeHours() {
        int current = Main.getCurrentUser();
        Main.command("signout");
        Main.command("signin 0 password");
        Main.command("assignemployeehours 0 4 10 10");
        Main.command("signout");
        Main.command("signin "+current+" password");
    }

    @And("user attempts to remove employee")
    public void userAttemptsToRemovesEmployee() {
        Main.command("removeemployee 4");
    }

    @Then("employee is removed")
    public void employeeIsRemoved() {
        assertTrue(Main.getEmployees().get(4).isRemoved());
    }

    @Then("employee is not removed")
    public void employeeIsNotRemoved() {
        assertFalse(Main.getEmployees().get(4).isRemoved());
    }

    @And("user attempts to removes employee from project")
    public void userAttemptsToRemovesEmployeeFromProject() {
        System.out.println(Main.projectEmployeeRelationExist(0,4));
        Main.command("removeemployeefromproject 0 4");
    }

    @Then("employee is removed from project")
    public void employeeIsRemovedFromProject() {
        assertEquals(false, Main.projectEmployeeRelationExist(0,4));
    }

    @Then("employee is not removed from project")
    public void employeeIsNotRemovedFromProject() {
        assertNotEquals(false, Main.projectEmployeeRelationExist(0,4));
    }

}
