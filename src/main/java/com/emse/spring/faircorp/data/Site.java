package com.emse.spring.faircorp.data;


public class Site {
    String ID;
    String Name;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Site(String ID, String name) {
        this.ID = ID;
        Name = name;
    }
}
