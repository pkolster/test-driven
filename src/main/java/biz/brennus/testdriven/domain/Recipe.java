package biz.brennus.testdriven.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @OneToMany
    private List<IngredientOfRecipe> ingredientList = new ArrayList<>();

    public Recipe() { }

    public Recipe(String name) {
        this.name = name;
    }

    public void addIngredient(Ingredient ingredient, double amount) {
        IngredientOfRecipe ingredientOfRecipe = new IngredientOfRecipe(ingredient, amount);
        this.ingredientList.add(ingredientOfRecipe);
    }
}
