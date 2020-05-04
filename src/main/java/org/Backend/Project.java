package org.Backend;

import java.util.ArrayList;

public class Project {
    private ArrayList<ProjectEmployeeRelation> employeeRelations = new ArrayList<ProjectEmployeeRelation>();
    private ArrayList<Activity> activities = new ArrayList<Activity>();
    private int status;
    private String name;
    private String description;

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public ArrayList<ProjectEmployeeRelation> getEmployeeRelations() {
        return employeeRelations;
    }

    public void setProjectManager(Employee employee){
        removeCurrentProjectManager();

        if (!Main.projectEmployeeRelationExist(this, employee)){
            employee.joinProject(this);
        }
        Main.findProjectEmployeeRelation(this, employee).setProjectManager(true);
        System.out.println("Employee "+Main.employees.indexOf(employee)+ " is now project manager for project "+Main.projects.indexOf(this));
    }
    private void removeCurrentProjectManager(){
        for(int i = 0; i < employeeRelations.size(); i++){
            if (employeeRelations.get(i).isProjectManager()){
                employeeRelations.get(i).setProjectManager(false);
                System.out.println("Employee "+Main.employees.indexOf(employeeRelations.get(i).getEmployee())+ " is no longer project manager for project "+Main.projects.indexOf(this));
                return;
            }
        }
    }

    public Employee getProjectManager(){
        for(int i = 0; i < employeeRelations.size(); i++){
            if (employeeRelations.get(i).isProjectManager()){
                return employeeRelations.get(i).getEmployee();
            }
        }
        return null;
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
        return getName() + "(" + Main.projects.indexOf(this) + ")";
    }
}
