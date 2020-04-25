package com.chrystian.amn.designPatterns.composite;

public abstract class Employee {
    private long id;
    private String name;

    public abstract int teamSize();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
