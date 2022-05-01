package biz.brennus.testdriven.domain;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ingredient that = (Ingredient) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
