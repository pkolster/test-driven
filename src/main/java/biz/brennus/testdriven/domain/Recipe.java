package biz.brennus.testdriven.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Recipe {
    private String name;
    private List<Ingredient> ingredientList = new ArrayList<>();

    public Recipe(String name) {
        this.name = name;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredientList.add(ingredient);
    }
}
