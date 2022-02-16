package by.rakovets.course.spring.framework.bean.example.xmlbased.model.impl;


import by.rakovets.course.spring.framework.bean.example.xmlbased.model.Knight;
import by.rakovets.course.spring.framework.bean.example.xmlbased.model.Quest;

public class BraveKnight implements Knight {
    private final Quest quest;
    private String name;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        System.out.println("Knight " + name + " embarked");
        quest.start();
    }

    public void setName(String name) {
        this.name = name;
    }
}
