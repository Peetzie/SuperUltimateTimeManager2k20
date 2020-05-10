package org.Backend;

import java.util.ArrayList;

public class Project extends Entity {//here we have the constructor for project with project logic included
    //initiation of variables
    private ArrayList<ProjectEmployeeRelation> employeeRelations = new ArrayList<ProjectEmployeeRelation>();
    private ArrayList<Activity> activities = new ArrayList<Activity>();
    private int status;
    private String description;
    private int estimatedTime;
    private long deadline;

    public Project(String name, String description, int estimatedTime, long deadline){//initiatoin of the object "Project"
        setName(name);
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


    public void printInformation(){
        System.out.println("________________"+getName()+"________________");
        System.out.println("Description: "+description);
        System.out.println("Status: "+status);
        System.out.println("Deadline: "+deadline);
        System.out.println("Estimated Time: "+estimatedTime);
        System.out.println("Removed: "+isRemoved());
        System.out.println("Activities:");
        for(int i = 0; i < activities.size(); i++){
            System.out.println("    "+activities.get(i));
            System.out.println("        Description: "+activities.get(i).getDescription());
            System.out.println("        Status: "+activities.get(i).getDescription());
            System.out.println("        Deadline: "+activities.get(i).getDeadline());
            System.out.println("        Estimated Time: "+activities.get(i).getEstimatedTime());
            System.out.println("        Removed: "+activities.get(i).isRemoved());
            System.out.println("        Employees:");
            for(int e = 0; e < activities.get(i).getEmployees().size(); e++){
                System.out.println("            "+activities.get(i).getEmployees().get(e));
            }
        }
        System.out.println("Employees:");
        Main.setPrintProjectInformationOnProjectEmployeeRelations(false);
        for (int i = 0; i < employeeRelations.size(); i++){
            System.out.println("    "+employeeRelations.get(i));
            System.out.println("        Hours:");
            for(int e = 0; e < employeeRelations.get(i).getHours().size(); e++){
                System.out.println("            "+employeeRelations.get(i).getHours().get(e));
            }
        }
    }

    //getters and setters
    public ArrayList<ProjectEmployeeRelation> getEmployeeRelations() {
        return employeeRelations;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public ArrayList<Activity> getActivitiesReal() {
        ArrayList<Activity> activityList = new ArrayList<Activity>();
        for(int i = 0; i < activities.size(); i++){
            if(!activities.get(i).isRemoved()){
                activityList.add(activities.get(i));
            }
        }
        return activityList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
