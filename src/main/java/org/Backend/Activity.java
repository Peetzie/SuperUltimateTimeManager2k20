package org.Backend;

import java.util.ArrayList;

public class Activity extends Entity { //This class is the constructor for creating activities
    //variable initiation
    private int deadline;
    private int estimatedTime;
    private String description;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private int status;

    public Activity(String name, String description, int estimatedTime, int deadline){//initiatoin of the object "Activity"
        setName(name);
        this.description = description;
        this.deadline = deadline;
        this.estimatedTime = estimatedTime;
    }
    //getters and setters
    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int duration) {
        this.estimatedTime = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString(){
        return getName();
    }
}
