package org.Backend;

import java.util.ArrayList;

public class ProjectEmployeeRelation {//constuctor for relation between project and employee
    //variable initiation
    private Project project = null;
    private Employee employee = null;
    private boolean projectManager;
    private ArrayList<Hour> hours = new ArrayList<Hour>();

    public ProjectEmployeeRelation(Project project, Employee employee){//initiatoin of the object "ProjectEmployeeRelation"
        this.project = project;
        this.employee = employee;
    }

    //getters and setters
    public boolean isProjectManager() {
        return projectManager;
    }

    public void setProjectManager(boolean projectManager) {
        this.projectManager = projectManager;
    }

    public ArrayList<Hour> getHours() {
        return hours;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    //to string function
    public String toString(){
        if (Main.isPrintProjectInformationOnProjectEmployeeRelations()){
            if(projectManager)
                return project.toString();
            return project.toString() + " (Project manager)";
        }
        if(projectManager)
            return employee.toString() + " (Project manager)";
        return employee.toString();
    }
}

