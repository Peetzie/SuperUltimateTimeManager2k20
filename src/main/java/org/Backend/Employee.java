package org.Backend;

import java.util.ArrayList;

public class Employee {


    private ArrayList<ProjectEmployeeRelation> projectRelations = new ArrayList<ProjectEmployeeRelation>();
    private boolean admin;
    private String password;
    private String name;

    public Employee(String password, String name, boolean admin){
        this.password = password;
        this.name = name;
        this.admin = admin;
    }

    public ArrayList<ProjectEmployeeRelation> getprojectRelations() {
        return projectRelations;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    //ProjectManager
    public void createActivity(int project, String title, String description, int deadline, int estimatedTime){
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            Main.getProjects().get(project).getActivities().add(new Activity(title,description,deadline,estimatedTime));
            System.out.println("Activity "+(Main.getProjects().get(project).getActivities().size()-1)+" has been created");
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }

    public void editEmployeesHours(int project, int employee, int index, int startTime, int duration){
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            Main.getEmployees().get(employee).editHours(project, index, duration, startTime);
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }

    public void assignActivity(int project, int activity, int employee){
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this) || Main.getEmployees().indexOf(this) == employee){
            if (Main.getProjects().get(project).getActivities().get(activity).getEmployees().contains(Main.getEmployees().get(employee))){
                System.out.println("Employee "+employee+" was already assigned to activity "+activity+" on project "+project+", so no harm done");
            }
            else{
                Main.getProjects().get(project).getActivities().get(activity).getEmployees().add(Main.getEmployees().get(employee));
                System.out.println("Employee "+employee+" has been assigned to activity "+activity+" on project "+project);
            }
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }

    public void changeProjectStatus(int project, int newStatus){
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            Main.getProjects().get(project).setStatus(newStatus);
            System.out.println("Status set to "+newStatus+" for project "+project);
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }

    //ProjectBoundEmployee
    public void getProjectInformation(){

    }

    public void leaveProject(int project){
        if(Main.projectEmployeeRelationExist(Main.getProjects().get(project),this)){
            if (Main.getProjects().get(project).getProjectManager().equals(this)){
                System.out.println("Project " + project + " no longer have a project manager");
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

    public void assignHours(int project, int startTime, int duration){
        Main.findProjectEmployeeRelation(Main.getProjects().get(project),this).getHours().add(new Hour(startTime, duration));
        System.out.println("Hours entry "+(Main.findProjectEmployeeRelation(Main.getProjects().get(project),this).getHours().size()-1)+" has been created for employee "+Main.getEmployees().indexOf(this)+" on project "+project);
    }

    public void editHours(int project, int index, int startTime, int duration){
        Main.findProjectEmployeeRelation(Main.getProjects().get(project),this).getHours().get(index).setStartTime(startTime);
        Main.findProjectEmployeeRelation(Main.getProjects().get(project),this).getHours().get(index).setDuration(duration);
        System.out.println("Hours entry "+index+" for employee "+Main.getEmployees().indexOf(this)+" on project "+project+" has been updated");
    }

    //Employee
    public void joinProject(Project project){
        if (!Main.projectEmployeeRelationExist(project, this)){
            projectRelations.add(new ProjectEmployeeRelation(project, this));
            project.getEmployeeRelations().add(projectRelations.get(projectRelations.size()-1));
            System.out.println("Employee "+Main.getEmployees().indexOf(this)+" is now on project "+Main.getProjects().indexOf(project));
        }
        else{
            System.out.println("Employee "+Main.getEmployees().indexOf(this)+" was already on project "+project+", so no harm done");
        }
    }

    public void joinActivity(int project, int activity){
        assignActivity(project,activity,Main.getEmployees().indexOf(this));
    }

    //Admin
    public void createNewEmployee(String password, String name, boolean admin){
        if (this.admin){
            Main.getEmployees().add(new Employee(password, name, admin));
            if (admin){
                System.out.println("Employee " +(Main.getEmployees().size()-1)+" has been created as admin");
            }
            else{
                System.out.println("Employee " +(Main.getEmployees().size()-1)+" has been created");
            }
        }
        else{
            System.out.println("Only admin can do this");
        }
    }

    public void createNewProject(String name, String description, int estimatedTime, long deadline){
        if (admin){
            Main.getProjects().add(new Project(name, description.replace("_"," "), estimatedTime, deadline));
            System.out.println("Project " +(Main.getProjects().size()-1)+" has been created");
        }
        else{
            System.out.println("Only admin can do this");
        }
    }

    //Admin and project manager
    public void assignProjectManager(int project, int employee){
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            if (Main.getProjects().size() > project){
                if (Main.getEmployees().size() > employee){
                    Main.getProjects().get(project).setProjectManager(Main.getEmployees().get(employee));
                }
                else{
                    System.out.println("Employee "+employee+" don't exist");
                }
            }
            else{
                System.out.println("Project "+project+" don't exist");
            }
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }

    public void assignEmployeeToProject(int project, int employee){
        if (admin || Main.getProjects().get(project).getProjectManager().equals(this)){
            Main.getEmployees().get(employee).joinProject(Main.getProjects().get(project));
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
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

    public String toString(){
        if(isAdmin()){
            return getName() + "(" + Main.getEmployees().indexOf(this) + ") [admin]";
        }
        return getName() + "(" + Main.getEmployees().indexOf(this) + ")";
    }
}

