package org.Backend;

import java.util.ArrayList;

public class Project {//here we have the constructor for project with project logic included
    //initiation of variables
    private ArrayList<ProjectEmployeeRelation> employeeRelations = new ArrayList<ProjectEmployeeRelation>();
    private ArrayList<Activity> activities = new ArrayList<Activity>();
    private int status;
    private String name;
    private String description;
    private int estimatedTime;
    private long deadline;

    public Project(String name, String description, int estimatedTime, long deadline){//initiatoin of the object "Project"
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.deadline = deadline;
    }

    public void setProjectManager(Employee employee){//sets the project manager of the project
        removeCurrentProjectManager();

        if (!Main.projectEmployeeRelationExist(this, employee)){
            employee.joinProject(this);
        }
        Main.findProjectEmployeeRelation(this, employee).setProjectManager(true);
        System.out.println("Employee "+Main.getEmployees().indexOf(employee)+ " is now project manager for project "+Main.getProjects().indexOf(this));
    }
    private void removeCurrentProjectManager(){//removes the project manager status
        for(int i = 0; i < employeeRelations.size(); i++){
            if (employeeRelations.get(i).isProjectManager()){
                employeeRelations.get(i).setProjectManager(false);
                System.out.println("Employee "+Main.getEmployees().indexOf(employeeRelations.get(i).getEmployee())+ " is no longer project manager for project "+Main.getProjects().indexOf(this));
                return;
            }
        }
    }

    public Employee getProjectManager(){//returns the project manager for the project (fancy getter)
        for(int i = 0; i < employeeRelations.size(); i++){
            if (employeeRelations.get(i).isProjectManager()){
                return employeeRelations.get(i).getEmployee();
            }
        }
        return null;
    }

    public boolean hasProjectManager(){//checks if the project has a project manager
        for(int i = 0; i < employeeRelations.size(); i++){
            if (employeeRelations.get(i).isProjectManager()){
                return true;
            }
        }
        return false;
    }


    //getters and setters
    public ArrayList<ProjectEmployeeRelation> getEmployeeRelations() {
        return employeeRelations;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString(){
        return getName() + " (" + Main.getProjects().indexOf(this) + ")";
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }
}
