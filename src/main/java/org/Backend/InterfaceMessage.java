package org.Backend;

public class InterfaceMessage {//communicates data to interface
    private String[] str;

    public InterfaceMessage(String [] str){
        this.str = str;
    }

    public String[] getStr() {
        return str;
    }
}
