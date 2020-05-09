package org.Backend;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Hour {//This class is the constructor for creating an hour object used for reporting work hours
    //variable initiation
    private long startTime;
    private long duration;

    public Hour(int startTime, int duration){//initiatoin of the object "Hour"
        this.startTime = startTime;
        this.duration = duration;
    }
    //getters and setters
    public int getStartTime() {
        return (int)startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return (int)duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String toString(){
        Date start = new Date(startTime*1000L);
        Date end = new Date((startTime+duration)*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
        String java_date = jdf.format(start);
        return jdf.format(start)+" - "+jdf.format(end)+" ("+ new DecimalFormat("#.##").format(((float)(duration)/3600)) +" hours)";
    }
}

