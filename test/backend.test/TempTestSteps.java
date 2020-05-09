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

}
