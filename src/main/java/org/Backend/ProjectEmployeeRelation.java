package org.Backend;

import java.util.ArrayList;

public class ProjectEmployeeRelation {
    private Project project = null;
    private Employee employee = null;
    private boolean projectManager;
    private ArrayList<Hour> hours = new ArrayList<Hour>();

    public ProjectEmployeeRelation(Project project, Employee employee){
        this.project = project;
        this.employee = employee;
    }

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
}

