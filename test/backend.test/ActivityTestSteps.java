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
        Main.command("newemployee  [name] (admin)")
    }

    @Given("that the current user is a project bound employee")
    public void thatTheEmployeeIsLoggedIn() throws Exception {
        assertTrue();
    }

}
