package application.entities;

import application.entities.interfaces.Printable;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Printable {


    private People people;
    private List<String> skills = new ArrayList();

    public Curriculum(People people) {
        this.people = people;
    }

    public void addSkill(String skill) {
        skills.add(skill);
    }

    @Override
    public void print() {
        System.out.println(people.toString() + " - " + skills);
    }
}
