package ca.bcit.comp2522.labs.lab04;

public class Human implements Terrestrial, Aquatic {
    @Override
    public void swim() {
        System.out.println("Human is Diving!");
    }

    @Override
    public void walk() {
        System.out.println("Human is Hopping!");
    }
}
