package by.rakovets.course.spring.framework.bean.example.xmlbased.model.impl;

import by.rakovets.course.spring.framework.bean.example.xmlbased.model.Quest;

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
