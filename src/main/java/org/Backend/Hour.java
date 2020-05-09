package org.Backend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

    public String toString(){
        Date start = new Date(startTime*1000L);
        Date end = new Date((startTime+duration)*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
        return jdf.format(start+" - "+end+" ("+((float)duration/3600)+")");
    }
}

