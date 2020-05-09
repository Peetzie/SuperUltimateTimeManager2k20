package org.Backend;

import java.util.ArrayList;

public class Activity { //This class is the constructor for creating activities
    //variable initiation
    private int deadline;
    private int estimatedTime;
    private String title;
    private String description;
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private int status;
    private boolean removed = false;

    public Activity(String title, String description, int estimatedTime, int deadline){//initiatoin of the object "Activity"
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public String toString(){
        return title;
    }
}
