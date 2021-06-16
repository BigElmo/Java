package Lesson_1;

import java.util.Arrays;

public class Box {

    private int[] mass = new int[]{1,2};

    public int[] getMass() {
        return mass;
    }

    public Box(String color, int weight, String name) {
        this.color = color;
        this.weight = weight;
        this.name = name;
    }

    public Box(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    String color;
    int weight;
    String name;

    public void info() {
        System.out.println(color + " " + weight + " " + name + " " + Arrays.toString(mass));
    }
}
