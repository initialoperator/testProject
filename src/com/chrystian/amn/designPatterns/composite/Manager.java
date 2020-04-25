package com.chrystian.amn.designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    private List<Employee> subs = new ArrayList<>();

    @Override
    public int teamSize(){
        int under = subs.stream().mapToInt(sub -> sub.teamSize()).sum();
        return 1 + under;
    }

    public void manages(Employee sub){
        this.subs.add(sub);
    }

    public void stopsManaging(Employee sub){
        this.subs.remove(sub);
    }
}
