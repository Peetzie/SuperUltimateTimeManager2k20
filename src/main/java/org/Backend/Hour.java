package org.Backend;

public class Hour {//This class is the constructor for creating an hour object used for reporting work hours
    //variable initiation
    private int startTime;
    private int duration;

    public Hour(int startTime, int duration){//initiatoin of the object "Hour"
        this.startTime = startTime;
        this.duration = duration;
    }
    //getters and setters
    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

