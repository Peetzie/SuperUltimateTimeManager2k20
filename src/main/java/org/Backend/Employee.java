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
    public void createActivity(){

    }

    public void editEmployeesHours(int project, int employee, int index, int startTime, int duration){
        if (admin || Main.projects.get(project).getProjectManager().equals(this)){
            Main.employees.get(employee).editHours(project, index, startTime, duration);
        }
        else{
            System.out.println("Only admin or project manager can do this");
        }
    }

    public void assignActivity(){

    }

    public void changeProjectStatus(int project, int newStatus){
        if (admin || Main.projects.get(project).getProjectManager().equals(this)){
            Main.projects.get(project).setStatus(newStatus);
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
        if(Main.projectEmployeeRelationExist(Main.projects.get(project),this)){
            if (Main.projects.get(project).getProjectManager().equals(this)){
                System.out.println("Project " + project + " no longer have a project manager");
            }
            for(int i = 0; i < projectRelations.size(); i++){
                if(projectRelations.get(i).getProject().equals(Main.projects.get(project))){
                    projectRelations.get(i).getProject().getEmployeeRelations().remove(projectRelations.get(i));
                    projectRelations.remove(projectRelations.get(i));
                    System.out.println("Employee "+Main.employees.indexOf(this)+" has been removed from project "+project);
                }
            }
        }
        else{
            System.out.println("Employee "+Main.employees.indexOf(this)+" was not on project "+project+", so no harm done");
        }

    }

    public void assignHours(int project, int startTime, int duration){
        Main.findProjectEmployeeRelation(Main.projects.get(project),this).getHours().add(new Hour(startTime, duration));
        System.out.println("Hours entry "+(Main.findProjectEmployeeRelation(Main.projects.get(project),this).getHours().size()-1)+" has been created for employee "+Main.employees.indexOf(this)+" on project "+project);
    }

    public void editHours(int project, int index, int startTime, int duration){
        Main.findProjectEmployeeRelation(Main.projects.get(project),this).getHours().get(index).setStartTime(startTime);
        Main.findProjectEmployeeRelation(Main.projects.get(project),this).getHours().get(index).setDuration(duration);
        System.out.println("Hours entry "+index+" for employee "+Main.employees.indexOf(this)+" on project "+project+" has been updated");
    }

    public void startCollaboration(){

    }

    //Employee
    public void joinProject(Project project){
        if (!Main.projectEmployeeRelationExist(project, this)){
            projectRelations.add(new ProjectEmployeeRelation(project, this));
            project.getEmployeeRelations().add(projectRelations.get(projectRelations.size()-1));
            System.out.println("Employee "+Main.employees.indexOf(this)+" is now on project "+Main.projects.indexOf(project));
        }
    }

    //Admin
    public void createNewEmployee(String password, String name, boolean admin){
        if (this.admin){
            Main.employees.add(new Employee(password, name, admin));
            if (admin){
                System.out.println("Employee " +(Main.employees.size()-1)+" has been created as admin");
            }
            else{
                System.out.println("Employee " +(Main.employees.size()-1)+" has been created");
            }
        }
        else{
            System.out.println("Only admin can do this");
        }
    }

    public void createNewProject(String name, String description){
        if (admin){
            Main.projects.add(new Project(name, description.replace("_"," ")));
            System.out.println("Project " +(Main.projects.size()-1)+" has been created");
        }
        else{
            System.out.println("Only admin can do this");
        }
    }

    //Admin and project manager
    public void assignProjectManager(int project, int employee){
        if (admin || Main.projects.get(project).getProjectManager().equals(this)){
            if (Main.projects.size() > project){
                if (Main.employees.size() > employee){
                    Main.projects.get(project).setProjectManager(Main.employees.get(employee));
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
        if (admin || Main.projects.get(project).getProjectManager().equals(this)){
            Main.employees.get(employee).joinProject(Main.projects.get(project));
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
            return getName() + "(" + Main.employees.indexOf(this) + ") [admin]";
        }
        return getName() + "(" + Main.employees.indexOf(this) + ")";
    }
}

