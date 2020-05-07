package org.Backend;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Employee {//here we have the constructor for employee with employee logic included
    //initiation of variables
    private ArrayList<ProjectEmployeeRelation> projectRelations = new ArrayList<ProjectEmployeeRelation>();
    private boolean admin;
    private String password;
    private String name;
    private boolean removed = false;

    public Employee(String password, String name, boolean admin){//initiatoin of the object "Employee"
        this.password = password;
        this.name = name;
        this.admin = admin;
    }

    //Project manager functions
    public boolean createActivity(int project, String title, String description, int deadline, int estimatedTime){//checks if user is admin or project manager and allows admins or project manager to create activities
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            Main.getProjects().get(project).getActivities().add(new Activity(title,description.replace("_"," "),deadline,estimatedTime));
            System.out.println("Activity "+(Main.getProjects().get(project).getActivities().size()-1)+" has been created");
            return true;
        }
        else{
            System.out.println("Only admin or project manager can do this");
            return false;
        }
    }

    public void editEmployeesHours(int project, int employee, int index, int startTime, int duration){//checks if user is admin or project manager and allows admins or project manager to edit hours
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            Main.getEmployees().get(employee).editHours(project, index, duration, startTime);
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }

    public boolean assignActivity(int project, int activity, int employee){//checks if user is admin or project manager and allows admins or project manager to assign employees to a assignment if they are not already assigned
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this) || Main.getEmployees().indexOf(this) == employee){
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

    public void changeProjectStatus(int project, int newStatus){//checks if user is admin or project manager and allows admins or project manager to change project status
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            Main.getProjects().get(project).setStatus(newStatus);
            System.out.println("Status set to "+newStatus+" for project "+project);
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }

    //Project bound employee functions
    public void getProjectInformation(){

    }

    public void leaveProject(int project){//allows an project bound employee to leave a project and checks if they are the project manager and notifies the employee that the project now has no project manager
        if(Main.projectEmployeeRelationExist(Main.getProjects().get(project),this)){
            if (Main.getProjects().get(project).hasProjectManager()) {
                if (Main.getProjects().get(project).getProjectManager().equals(this)){
                    System.out.println("Project " + project + " no longer have a project manager");
                }
            }
            for(int i = 0; i < projectRelations.size(); i++){
                if(projectRelations.get(i).getProject().equals(Main.getProjects().get(project))){
                    projectRelations.get(i).getProject().getEmployeeRelations().remove(projectRelations.get(i));
                    projectRelations.remove(projectRelations.get(i));
                    System.out.println("Employee "+Main.getEmployees().indexOf(this)+" has been removed from project "+project);
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
            while(Main.getEmployees().get(employee).projectRelations.size() > 0){
                Main.getEmployees().get(employee).projectRelations.get(0).getProject().getEmployeeRelations().remove(projectRelations.get(0));
                Main.getEmployees().get(employee).projectRelations.remove(0);
            }
            Main.getEmployees().get(employee).setRemoved(true);
            System.out.println("Employee "+employee+" has been removed");
            return true;
        } else {
            return false;
        }
    }

    //Admin and project manager functions
    public boolean assignProjectManager(int project, int employee){//allows project managers to set new project manager and allows admins to set a project manager
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
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
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
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
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            Main.getProjects().get(project).setStatus(status);
            System.out.println("Status for project "+project+" has been set to "+status);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //to string function
    public String toString(){
        if(isAdmin()){
            return getName() + " (" + Main.getEmployees().indexOf(this) + ") [admin]";
        }
        return getName() + " (" + Main.getEmployees().indexOf(this) + ")";
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }
}

