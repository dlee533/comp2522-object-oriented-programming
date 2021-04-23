package ca.bcit.comp2522.labs.lab04;

public class Cormorant implements Aerial, Aquatic, Terrestrial {

    @Override
    public void fly() {
        System.out.println("Cormorant is Swooping!");
    }

    @Override
    public void swim() {
        System.out.println("Cormorant is Diving!");
    }

    @Override
    public void walk() {
        System.out.println("Cormorant is Hopping!");
    }
}
