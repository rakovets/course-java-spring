package com.rakovets.course.spring.example.bean.knights;

import java.util.List;


public class SlayDragonQuest implements Quest {
    private List<String> steps;

    public void start() {
        steps.forEach(System.out::println);
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
