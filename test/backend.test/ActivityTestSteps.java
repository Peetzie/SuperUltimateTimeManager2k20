package backend.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Backend.Main;
import org.Backend.Project;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActivityTestSteps {
    public ActivityTestSteps(){
        Main.setup(this);
        Main.command("signin 0 password");

        Main.command("newemployee password testPM");    //id:1
        Main.command("newemployee password testPBE");   //id:2
        Main.command("newemployee password testE");     //id:3

        Main.command("newproject testProject test 10 10");
        Main.command("assignpm testProject testPM");
        Main.command("assignemployee testProject testPBE");
        Main.command("newactivity testProject testActivity test 10 10");

        Main.command("signout");
    }

    @Given("that the current user is a project bound employee")
    public void thatTheEmployeeIsLoggedIn() throws Exception {
        Main.command("signin 2 password");
        assertTrue(Main.projectEmployeeRelationExist(0, 2));
    }


    @And("the user assigns hours")
    public void theUserAssignsHours() {
        Main.command("assignhours testProject 10 10");
    }
}
