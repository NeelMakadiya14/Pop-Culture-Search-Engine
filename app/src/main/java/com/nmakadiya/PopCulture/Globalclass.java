package com.nmakadiya.PopCulture;


public class Globalclass {

    private static Globalclass instance;
    private String name;
    private String id;

    public static synchronized Globalclass getInstance() {
        if (instance == null) {
            instance = new Globalclass();
        }
        return instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }
}


