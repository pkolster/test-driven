package biz.brennus.testdriven.domain;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ShoppingList {
    private List<Ingredient> shoppingItems = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        shoppingItems.addAll(recipe.getIngredientList());
    }
}
