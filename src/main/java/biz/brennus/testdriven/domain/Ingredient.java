package biz.brennus.testdriven.domain;

import lombok.Data;

@Data
public class Ingredient {
    private String name;
    private double amount;
    private String unit;

    public Ingredient(String name) {
        this.name = name;
    }

    public Ingredient(String name, double amount, String unit) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }
}
