package com.chrystian.amn.designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends Employee {
    private List<String> works = new ArrayList<>();
    @Override
    public int teamSize(){
        return 1;
    }

    public void assignWork(String work){
        this.works.add(work);
    }
}
