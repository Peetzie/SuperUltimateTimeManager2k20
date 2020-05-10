package org.Backend;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Employee extends Actor{//here we have the constructor for employee with employee logic included
    //initiation of variables
    private ArrayList<ProjectEmployeeRelation> projectRelations = new ArrayList<ProjectEmployeeRelation>();
    private boolean admin;
    private String password;

    public Employee(String password, String name, boolean admin){//initiatoin of the object "Employee"
        this.password = password;
        setName(name);
        this.admin = admin;
    }

    //Project manager functions
    //checks if user is admin or project manager and allows admins or project manager to create activities
    public boolean createActivity(int project, String title, String description, int deadline, int estimatedTime){
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getProjects().get(project).getActivities().add(new Activity(title,description.replace("_"," "),deadline,estimatedTime));
            System.out.println("Activity "+(Main.getProjects().get(project).getActivities().size()-1)+" has been created");
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }
    //checks if user is admin or project manager and allows admins or project manager to edit hours
    public void editEmployeesHours(int project, int employee, int index, int startTime, int duration){
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getEmployees().get(employee).editHours(project, index, duration, startTime);
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }
    public void assignEmployeesHours(int project, int employee, int startTime, int duration){
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getEmployees().get(employee).assignHours(project,startTime,duration);
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }
    public boolean setDeadline(int project, int deadline){
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getProjects().get(project).setDeadline(deadline);
            System.out.println("Deadline for project "+project+" set to "+deadline);
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }public boolean setActivityDeadline(int project, int activity, int deadline){
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getProjects().get(project).getActivities().get(activity).setDeadline(deadline);
            System.out.println("Deadline for project "+project+" set to "+deadline);
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }
    public boolean removeActivity(int project, int activity){
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getProjects().get(project).getActivities().get(activity).setRemoved(true);
            Main.getProjects().get(project).getActivities().get(activity).getEmployees().clear();
            System.out.println("Activity "+activity+" has been removed from project "+project);
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }
    //checks if user is admin or project manager and allows admins or project manager to assign employees to a assignment if they are not already assigned
    public boolean assignActivity(int project, int activity, int employee){
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager()) || Main.getEmployees().indexOf(this) == employee){
            if (Main.getProjects().get(project).getActivities().get(activity).getEmployees().contains(Main.getEmployees().get(employee))){
                System.out.println("Employee "+employee+" was already assigned to activity "+activity+" on project "+project+", so no harm done");

            }
            else{
                Main.getProjects().get(project).getActivities().get(activity).getEmployees().add(Main.getEmployees().get(employee));
                System.out.println("Employee "+employee+" has been assigned to activity "+activity+" on project "+project);
            }
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }

    //Project bound employee functions
    public void getProjectInformation(){

    }
    //allows an project bound employee to leave a project and checks if they are the project manager and notifies the employee that the project now has no project manager
    public void leaveProject(int project, int employee){
        if(this.equals(Main.getEmployees().get(employee)) || admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            if (Main.getProjects().get(project).hasProjectManager()) {
                if (Main.getProjects().get(project).getProjectManager().equals(Main.getEmployees().get(employee))){
                    System.out.println("Project " + project + " no longer have a project manager");
                }
            }
            for(int i = 0; i < Main.getEmployees().get(employee).getProjectRelations().size(); i++){
                if(Main.getEmployees().get(employee).getProjectRelations().get(i).getProject().equals(Main.getProjects().get(project))){
                    Main.getEmployees().get(employee).getProjectRelations().get(i).getProject().getEmployeeRelations().remove(Main.getEmployees().get(employee).getProjectRelations().get(i));
                    Main.getEmployees().get(employee).getProjectRelations().remove(Main.getEmployees().get(employee).getProjectRelations().get(i));
                    System.out.println("Employee "+employee+" has been removed from project "+project);
                }
            }
        }
        else{
            System.out.println("Employee "+Main.getEmployees().indexOf(this)+" was not on project "+project+", so no harm done");
        }

    }

    public void assignHours(int project, int startTime, int duration){//allows project bound employees to report work hours on a given project
        Main.findProjectEmployeeRelation(Main.getProjects().get(project),this).getHours().add(new Hour(startTime, duration));
        System.out.println("Hours entry "+(Main.findProjectEmployeeRelation(Main.getProjects().get(project),this).getHours().size()-1)+" has been created for employee "+Main.getEmployees().indexOf(this)+" on project "+project);
    }

    public void editHours(int project, int index, int startTime, int duration){//allows project bound employees to edit previously reported hours
        Main.findProjectEmployeeRelation(Main.getProjects().get(project),this).getHours().get(index).setStartTime(startTime);
        Main.findProjectEmployeeRelation(Main.getProjects().get(project),this).getHours().get(index).setDuration(duration);
        System.out.println("Hours entry "+index+" for employee "+Main.getEmployees().indexOf(this)+" on project "+project+" has been updated");
    }

    //Employee functions
    public void joinProject(Project project){//allows an employee to join a project
        if (!Main.projectEmployeeRelationExist(project, this)){
            projectRelations.add(new ProjectEmployeeRelation(project, this));
            project.getEmployeeRelations().add(projectRelations.get(projectRelations.size()-1));
            System.out.println("Employee "+Main.getEmployees().indexOf(this)+" is now on project "+Main.getProjects().indexOf(project));
        }
        else{
            System.out.println("Employee "+Main.getEmployees().indexOf(this)+" was already on project "+project+", so no harm done");
        }
    }

    public void joinActivity(int project, int activity){//allows an employee to join an activity
        assignActivity(project,activity,Main.getEmployees().indexOf(this));
    }

    //Admin functions
    public boolean createNewEmployee(String password, String name, boolean admin){//allows an admin to create an employee
        if (this.admin){
            Main.getEmployees().add(new Employee(password, name, admin));
            if (admin){
                System.out.println("Employee " +(Main.getEmployees().size()-1)+" has been created as admin");
            }
            else{
                System.out.println("Employee " +(Main.getEmployees().size()-1)+" has been created");
            }
            return true;
        }
        else{
            System.out.println("Only admin can do this");
            return false;
        }
    }

    public boolean createNewProject(String name, String description, int estimatedTime, long deadline){//allows an admin to create a project
        if (admin){
            Main.getProjects().add(new Project(name, description.replace("_"," "), estimatedTime, deadline));
            System.out.println("Project " +(Main.getProjects().size()-1)+" has been created");
            return true;
        }
        else{
            System.out.println("Only admin can do this");
            return false;
        }
    }

    public boolean removeEmployee(int employee){
        if (admin) {
            if (!this.equals(Main.getEmployees().get(employee))) {
                while(Main.getEmployees().get(employee).getProjectRelations().size() > 0){
                    Main.getEmployees().get(employee).getProjectRelations().get(0).getProject().getEmployeeRelations().remove(Main.getEmployees().get(employee).getProjectRelations().get(0));
                    Main.getEmployees().get(employee).getProjectRelations().remove(0);
                }
                Main.getEmployees().get(employee).setRemoved(true);
                System.out.println("Employee "+employee+" has been removed");
                return true;
            } else {
                System.out.println("Removeing one self is not possible");
                return false;
            }
        } else {
            System.out.println("Only admin can do this");
            return false;
        }
    }

    public boolean removeProject(int project){
        if (admin) {
            while(Main.getProjects().get(project).getEmployeeRelations().size() > 0){
                Main.getProjects().get(project).getEmployeeRelations().get(0).getEmployee().getProjectRelations().remove(Main.getProjects().get(project).getEmployeeRelations().get(0));
                Main.getProjects().get(project).getEmployeeRelations().remove(0);
            }
            Main.getProjects().get(project).setRemoved(true);
            System.out.println("Project "+project+" has been removed");
            return true;
        } else {
            System.out.println("Only admin can do this");
            return false;
        }
    }

    //Admin and project manager functions
    //allows project managers to set new project manager and allows admins to set a project manager
    public boolean assignProjectManager(int project, int employee){
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            if (Main.getProjects().size() > project){
                if (Main.getEmployees().size() > employee){
                    Main.getProjects().get(project).setProjectManager(Main.getEmployees().get(employee));
                    System.out.println("Employee "+employee+" has been assinged as project manager");
                    return true;
                }
                else{
                    System.out.println("Employee "+employee+" don't exist");
                    return false;
                }
            }
            else{
                System.out.println("Project "+project+" don't exist");
                return false;
            }
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }

    public boolean assignEmployeeToProject(int project, int employee){//allows admins and project managers to assign employees to a project
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getEmployees().get(employee).joinProject(Main.getProjects().get(project));
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }

    public ArrayList<ProjectEmployeeRelation> getManagerProjects(){
        ArrayList<ProjectEmployeeRelation> managerProjects = new ArrayList<>();
        for(int i = 0; i < projectRelations.size(); i++){
            if (projectRelations.get(i).isProjectManager()) {
                managerProjects.add(projectRelations.get(i));
            }
        }
        return managerProjects;
    }

    public boolean setProjectStatus(int project, int status){//allows admins and project managers to assign employees to a project
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getProjects().get(project).setStatus(status);
            System.out.println("Status for project "+project+" has been set to "+status);
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }

    public boolean setActivityStatus(int project, int activity, int status){//allows admins and project managers to assign employees to a project
        if (admin || this.equals(Main.getProjects().get(project).getProjectManager())){
            Main.getProjects().get(project).getActivities().get(activity).setStatus(status);
            System.out.println("Status for activity "+activity+" on project "+project+" has been set to "+status);
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }

    //getters and setters
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public ArrayList<ProjectEmployeeRelation> getProjectRelations() {
        return projectRelations;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //to string function
    public String toString(){
        if(isAdmin()){
            return getName() + " (" + Main.getEmployees().indexOf(this) + ") [admin]";
        }
        return getName() + " (" + Main.getEmployees().indexOf(this) + ")";
    }
}

