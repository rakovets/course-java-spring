package by.rakovets.course.spring.framework.bean.knights;


public class BraveKnight implements Knight {
    private Quest quest;
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
