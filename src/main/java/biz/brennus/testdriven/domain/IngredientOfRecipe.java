package biz.brennus.testdriven.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class IngredientOfRecipe {
    @Id
    @GeneratedValue
    private Long id;

    private double amount;

    @ManyToOne
    private Ingredient ingredient;

    public IngredientOfRecipe() { }

    public IngredientOfRecipe(Ingredient ingredient, double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }
}
