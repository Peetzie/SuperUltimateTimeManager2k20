package backend.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.Backend.Main;
import static org.junit.Assert.*;

public class TempTestSteps {
    TempTestSteps(){
        Main.command("signin 0 password");

        Main.command("newemployee password testPM");    //id:1
        Main.command("newemployee password testPBE");   //id:2
        Main.command("newemployee password testE");     //id:3

        Main.command("newproject testProjectWPM test 10 10");
        Main.command("newproject testProjectWOPM test 10 10");
        Main.command("assignpm 0 1");
        Main.command("assignemployee 0 2");


        Main.command("signout");
    }
    /*
    @Then("user creates new project")
    public void userCreatesNewProject() {
        assertEquals(2,Main.getProjects().size());
    }

    @Then("user fails to create new project")
    public void userFailsToCreateNewProject() {
        assertEquals(1,Main.getProjects().size());
    }

    @Then("current user assigns a new projectmanager to the unmanaged project")
    public void currentUserAssignsANewProjectmanagerToTheUnmanagedProject() {
        assertEquals(true,Main.getProjects().get(1).hasProjectManager());
    }

    @Then("current user fails to assigns a new projectmanager to the unmanaged project")
    public void currentUserFailsToAssignsANewProjectmanagerToTheUnmanagedProject() {
        assertEquals(false,Main.getProjects().get(1).hasProjectManager());
    }

    @And("current user assigns a new projectmanager to new project")
    public void userAssignsProjectToNewProject() {
        assertEquals(Main.getEmployees().get(4),Main.getProjects().get(0).getProjectManager());
    }


    @Then("user changes the status of the project")
    public void userChangesTheStatusOfTheProject() {
        assertEquals(Main.getEmployees().get(1),Main.getProjects().get(0).getStatus());
    }

    @Then("user fails to change the status of the project")
    public void userFailsToChangeTheStatusOfTheProject() {
        assertEquals(0,Main.getProjects().get(0).getStatus());
    }

    @Then("user deletes the project")
    public void userDeletesTheProject() {
        assertEquals(0,Main.getProjects().size());
    }

    @Then("user fails to delete the project")
    public void userFailsToDeleteTheProject() {
        assertEquals(1,Main.getProjects().size());
    }

     */

}
