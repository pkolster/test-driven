package biz.brennus.testdriven.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Data;

@Data
public class ShoppingList {
    private List<IngredientOfRecipe> shoppingItems = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        List<IngredientOfRecipe> ingredientList = recipe.getIngredientList();
        for (IngredientOfRecipe ingredientOfRecipe: ingredientList) {
            Optional<IngredientOfRecipe> found = findIngredientOfRecipe(ingredientOfRecipe.getIngredient().getName());
            if (found.isEmpty()) {
                shoppingItems.add(ingredientOfRecipe);
            } else {
                IngredientOfRecipe foundIngredient = found.get();
                foundIngredient.setAmount(foundIngredient.getAmount() + ingredientOfRecipe.getAmount());
            }
        }
    }

    public Optional<IngredientOfRecipe> findIngredientOfRecipe(String name) {
        return shoppingItems.stream().filter(ingredientOfRecipe -> ingredientOfRecipe.getIngredient().getName().equals(name)).findFirst();
    }
}
