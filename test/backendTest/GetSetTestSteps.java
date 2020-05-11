package backendTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.Backend.*;
import org.Backend.Main;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class GetSetTestSteps {
    private Activity testActivity = new Activity("test", "testing", 1337,1337);
    private Employee testEmployee = new Employee("testingpassword","TestEmployee",false);
    private Hour testHour;
    private Project testProject;
    private ProjectEmployeeRelation testPME;

    public GetSetTestSteps(){
        testActivity = new Activity("test", "testing", 1337,69420);
        testEmployee = new Employee("testingpassword","TestEmployee",false);
        testHour = new Hour(0,1337);
        String[] TestInterfacemessageArray = {"TestInterfacemessage0","TestInterfacemessage1","TestInterfacemessage2","TestInterfacemessage3"};
        testProject = new Project("testProject","testing Project",1337,69420);
        testPME = new ProjectEmployeeRelation(testProject,testEmployee);

    }
//Activity.java testSteps
    @Given("activity.java is instantiated")
    public void givenActivityIsInstantiated() throws Exception {
        assertTrue(testActivity instanceof Activity);
    }

    @Then("system gets deadline for activity")
    public void systemGetsDeadlineForActivity() {
        assertEquals(true, Integer.class.isInstance(testActivity.getDeadline()));
    }

    @Then("system gets estimated time  for activity")
    public void systemGetsEstimatedTimeForActivity() {
        assertEquals(true, Integer.class.isInstance(testActivity.getEstimatedTime()));
    }
    @Then("system gets name for activity")
    public void systemGetsNameForActivity() {
        assertEquals(true, String.class.isInstance(testActivity.getName()));
    }

    @Then("system gets description for activity")
    public void systemGetsDescriptionForActivity() {
        assertEquals(true, String.class.isInstance(testActivity.getDescription()));
    }

    @Then("system gets employees for activity")
    public void systemGetsEmployeesForActivity() {
        assertEquals(true, ArrayList.class.isInstance(testActivity.getEmployees()));
    }

    @Then("system gets status for activity")
    public void systemGetsStatusForActivity() {
        assertEquals(true, Integer.class.isInstance(testActivity.getStatus()));
    }

    @Then("system gets isRemoved for activity")
    public void systemGetsIsRemovedForActivity() {
        assertEquals(true, Boolean.class.isInstance(testActivity.isRemoved()));
    }

    @Then("system gets activity title as a string")
    public void systemGetsActivityTitleAsAString() {
        assertEquals(true, Boolean.class.isInstance(testActivity.isRemoved()));
    }

    @Then("system sets deadline for activity")
    public void systemSetsDeadlineForActivity() {
        int dedbefore = testActivity.getDeadline();
        testActivity.setDeadline(1337);
        int dedafter = testActivity.getDeadline();
        assertEquals(true, dedbefore != dedafter);
    }

    @Then("system sets estimated time for activity")
    public void systemSetsEstimatedTimeForActivity() {
        int estbefore = testActivity.getEstimatedTime();
        testActivity.setEstimatedTime(69);
        int estafter = testActivity.getEstimatedTime();
        assertEquals(true, estbefore != estafter);
    }


    @Then("system sets title for activity")
    public void systemSetsTitleForActivity() {
        String titbefore = testActivity.getName();
        testActivity.setName("updated");
        String titafter = testActivity.getName();
        assertEquals(true, titbefore != titafter);

    }

    @Then("system sets description for activity")
    public void systemSetsDescriptionForActivity() {
        String descbefore = testActivity.getDescription();
        testActivity.setDescription("updated");
        String descafter = testActivity.getDescription();
        assertEquals(true, descbefore != descafter);
    }

    @Then("system sets status for activity")
    public void systemSetsStatusForActivity() {
        int statusbefore = testActivity.getStatus();
        testActivity.setStatus(2);
        int statusafter = testActivity.getStatus();
        assertEquals(true, statusbefore != statusafter);
    }

    @Then("system sets isRemoved for activity")
    public void systemSetsIsRemovedForActivity() {
        boolean isRemovedBefore = testActivity.isRemoved();
        testActivity.setRemoved(true);
        boolean isRemovedAfter = testActivity.isRemoved();
        assertEquals(true, isRemovedBefore != isRemovedAfter);
    }

//Employee.java

    @Given("that employee.java is instantiated")
    public void thatEmployeeJavaIsInstantiated() {
        assertTrue(testEmployee instanceof Employee);
    }

    @Then("system gets project employee relations for employee")
    public void systemGetsProjectEmployeeRelationsForEmployee() {
        assertEquals(true, ArrayList.class.isInstance(testEmployee.getProjectRelations()));
    }

    @Then("system gets projects which the employee manages for employee")
    public void systemGetsProjectsWhichTheEmployeeManagesForEmployee() {
        assertEquals(true, ArrayList.class.isInstance(testEmployee.getManagerProjects()));
    }

    @Then("system gets admin boolean for employee")
    public void systemGetsAdminBooleanForEmployee() {
        assertEquals(true, Boolean.class.isInstance(testEmployee.isAdmin()));
    }

    @Then("system gets password for employee")
    public void systemGetsPasswordForEmployee() {
        assertEquals(true, String.class.isInstance(testEmployee.getPassword()));
    }

    @Then("system gets name for employee")
    public void systemGetsNameForEmployee() {
        assertEquals(true, String.class.isInstance(testEmployee.getName()));
    }

    @Then("system gets employee is removed boolean")
    public void systemGetsEmployeeIsRemovedBoolean() {
        assertEquals(true, Boolean.class.isInstance(testEmployee.isRemoved()));
    }

    @Then("system gets employee as a string")
    public void systemGetsEmployeeAsAString() {
        assertEquals(true, String.class.isInstance(testActivity.toString()));
    }



    @Then("system sets admin boolean for employee")
    public void systemSetsAdminBooleanForEmployee() {
        Boolean isAdminBefore  = testEmployee.isAdmin();
        testEmployee.setAdmin(true);
        Boolean isAdminAfter  = testEmployee.isAdmin();
        assertEquals(true,isAdminBefore != isAdminAfter);
    }

    @Then("system sets password for employee")
    public void systemSetsPasswordForEmployee() {
        String pwbefore = testEmployee.getPassword();
        testEmployee.setPassword("newpassword");
        String pwafter = testEmployee.getPassword();
        assertEquals(true, pwbefore != pwafter);
    }

    @Then("system sets name for employee")
    public void systemSetsNameForEmployee() {
        String namebefore = testEmployee.getName();
        testEmployee.setName("newname");
        String nameafter = testEmployee.getName();
        assertEquals(true, namebefore != nameafter);

    }

    @Then("system sets employee is removed")
    public void systemSetsEmployeeIsRemoved() {
        Boolean isRemovedBefore  = testEmployee.isRemoved();
        testEmployee.setRemoved(true);
        Boolean isRemovedAfter  = testEmployee.isRemoved();
        assertEquals(true,isRemovedBefore != isRemovedAfter);
    }

//Hour.java

    @Given("hour.java is instantiated")
    public void hourJavaIsInstantiated() {
        assertTrue(testHour instanceof Hour);
    }

    @Then("system gets duration for hour")
    public void systemGetsDurationForHour() {
        assertEquals(true, Integer.class.isInstance(testHour.getDuration()));

    }

    @Then("system gets starttime for hour")
    public void systemGetsStarttimeForHour() {
        assertEquals(true, Integer.class.isInstance(testHour.getStartTime()));
    }

    @Then("system gets hour as a string")
    public void systemGetsHourAsAString() {
        assertEquals(true, String.class.isInstance(testHour.toString()));
    }


    @Then("system sets duration for hour")
    public void systemSetsDurationForHour() {
        int durbefore =testHour.getDuration();
        testHour.setDuration(25);
        int durafter = testHour.getDuration();
        assertEquals(true, durbefore != durafter);
    }

    @Then("system sets starttime for hour")
    public void systemSetsStarttimeForHour() {
        int ssbefore =testHour.getStartTime();
        testHour.setStartTime(2500);
        int ssafter = testHour.getStartTime();
        assertEquals(true, ssbefore != ssafter);
    }

//main.java
    @Given("Main.java is being tested")
    public void mainJavaIsBeingTested() {
        assertTrue(true);
    }

    @Then("system gets projects for main")
    public void systemGetsProjectsForMain() {
        assertEquals(true, ArrayList.class.isInstance(Main.getProjects()));
    }

    @Then("system gets employees for main")
    public void systemGetsEmployeesForMain() {
        assertEquals(true, ArrayList.class.isInstance(Main.getEmployees()));
    }

    @Then("system gets current user for main")
    public void systemGetsCurrentUserForMain() {
        assertEquals(true, Integer.class.isInstance(Main.getCurrentUser()));
    }

    @Then("system gets real employees")
    public void systemGetsRealEmployees() {
        assertEquals(true, ArrayList.class.isInstance(Main.getEmployeesReal()));
    }

    @Then("system gets printProjectInformationOnProjectEmployeeRelations for main")
    public void systemGetsPrintProjectInformationOnProjectEmployeeRelationsAsAStringForMain() {
        assertEquals(true, Boolean.class.isInstance(Main.isPrintProjectInformationOnProjectEmployeeRelations()));
    }

    @Then("system gets active projects for main")
    public void systemGetsProjectsByStatusForMain() {
        assertEquals(true,ArrayList.class.isInstance(Main.getProjectsReal()));
    }

    @Then("system gets projects by status for main")
    public void systemGetsActiveProjectsForMain() {
        assertEquals(true,ArrayList.class.isInstance(Main.getProjectByStatus(0,2)));
    }


    @Then("system sets printProjectInformationOnProjectEmployeeRelations for main")
    public void systemSetsPrintProjectInformationOnProjectEmployeeRelationsForMain() {
        boolean statebefore = Main.isPrintProjectInformationOnProjectEmployeeRelations();
        Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
        boolean stateafter = Main.isPrintProjectInformationOnProjectEmployeeRelations();
        assertEquals(true,statebefore!=stateafter);

    }
//ProjectEmployeeRelation.java
    @Given("ProjectEmployeeRelations.java is instantiated")
    public void projectemployeerelationsJavaIsInstantiated() {
        assertTrue(testPME instanceof ProjectEmployeeRelation);
    }

    @Then("system gets isProjectmanager for ProjectEmployeeRelations")
    public void systemGetsIsProjectmanagerForProjectEmployeeRelations() {
        assertEquals(true, Boolean.class.isInstance(testPME.isProjectManager()));

    }

    @Then("system gets hours for ProjectEmployeeRelations")
    public void systemGetsHoursForProjectEmployeeRelations() {
        assertEquals(true, ArrayList.class.isInstance(testPME.getHours()));
    }

    @Then("system gets project for ProjectEmployeeRelations")
    public void systemGetsProjectForProjectEmployeeRelations() {
        assertEquals(true, Project.class.isInstance(testPME.getProject()));
    }

    @Then("system gets Employees for ProjectEmployeeRelations")
    public void systemGetsEmployeesForProjectEmployeeRelations() {
        assertEquals(true, Employee.class.isInstance(testPME.getEmployee()));
    }

    @Then("system gets ProjectEmployeeRelations as a string for ProjectEmployeeRelations")
    public void systemGetsProjectEmployeeRelationsAsAStringForProjectEmployeeRelations() {
        assertEquals(true, String.class.isInstance(testPME.toString()));
    }

    @Then("system sets isProjectmanager for ProjectEmployeeRelations")
    public void systemSetsIsProjectmanagerForProjectEmployeeRelations() {
        boolean ispmBefore = testPME.isProjectManager();
        testPME.setProjectManager(true);
        boolean ispmAfter = testPME.isProjectManager();
        assertEquals(true,ispmBefore != ispmAfter);

    }

//Project.java

    @Given("that Project.java is instantiated")
    public void thatProjectJavaIsInstantiated() {
        assertTrue(testProject instanceof Project);
    }

    @Then("system gets employee relations for project")
    public void systemGetsEmployeeRelationsForProject() {
        assertEquals(true, ArrayList.class.isInstance(testProject.getEmployeeRelations()));
    }

    @Then("system gets activities for project")
    public void systemGetsActivitiesForProject() {
        assertEquals(true, ArrayList.class.isInstance(testProject.getActivities()));
    }

    @Then("system gets status for project")
    public void systemGetsStatusForProject() {
        assertEquals(true, Integer.class.isInstance(testProject.getStatus()));
    }

    @Then("system gets description for project")
    public void systemGetsDescriptionForProject() {
        assertEquals(true, String.class.isInstance(testProject.getDescription()));
    }

    @Then("system gets estimated time for project")
    public void systemGetsEstimatedTimeForProject() {
        assertEquals(true, Integer.class.isInstance(testProject.getEstimatedTime()));
    }

    @Then("system gets deadline for project")
    public void systemGetsDeadlineForProject() {
        assertEquals(true, Long.class.isInstance(testProject.getDeadline()));
    }

    @Then("system gets project as a string for project")
    public void systemGetsProjectAsAStringForProject() {
        assertEquals(true, String.class.isInstance(testProject.toString()));
    }

    @Then("system sets status for project")
    public void systemSetsStatusForProject() {
        int statusbefore = testProject.getStatus();
        testProject.setStatus(2);
        int statusafter = testProject.getStatus();
        assertEquals(true,statusbefore != statusafter);
    }

    @Then("system sets description for project")
    public void systemSetsDescriptionForProject() {
        String descbefore = testProject.getDescription();
        testProject.setDescription("new description");
        String descafter = testProject.getDescription();
        assertEquals(false,descbefore.equals(descafter));
    }

    @Then("system sets estimated time for project")
    public void systemSetsEstimatedTimeForProject() {
        int estTimeBefore = testProject.getEstimatedTime();
        testProject.setEstimatedTime(2);
        int estTimeafter = testProject.getEstimatedTime();
        assertEquals(true,estTimeBefore != estTimeafter);
    }

    @Then("system sets deadline for project")
    public void systemSetsDeadlineForProject() {
        long dedbefore = testProject.getDeadline();
        testProject.setDeadline(2);
        long dedafter = testProject.getDeadline();
        assertEquals(true,dedbefore != dedafter);
    }



}
