package backend.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.Backend.Main;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActivityTestSteps {
    public ActivityTestSteps(){
        Main.setup(this);
        Main.command("signin 0 password");

        Main.command("newemployee password testPM");
        Main.command("newemployee password testPBE");
        Main.command("newemployee password testE");

        Main.command("newproject testProject test 10 10");
        Main.command("assignpm testProject testPM");
    }

    @Given("that the current user is a project bound employee")
    public void thatTheEmployeeIsLoggedIn() throws Exception {
    }

}
