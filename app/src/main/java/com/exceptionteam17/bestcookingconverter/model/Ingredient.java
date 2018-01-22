package com.exceptionteam17.bestcookingconverter.model;

/**
 * Created by mironov on 1/2/18.
 */

public class Ingredient {

    private String name;
    private Double gramsInCup;

    public Ingredient(String name, Double gramsInCup) {
        this.name = name;
        this.gramsInCup = gramsInCup;
    }

    public String getName() {
        return name;
    }

    public Double getGramsInCup() {
        return gramsInCup;
    }
}
