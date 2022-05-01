package biz.brennus.testdriven.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Data;

@Data
public class ShoppingList {
    private List<Ingredient> shoppingItems = new ArrayList<>();

    public void addRecipe(Recipe recipe) {
        List<Ingredient> ingredientList = recipe.getIngredientList();
        for (Ingredient ingredient: ingredientList) {
            Optional<Ingredient> found = findIngredient(ingredient.getName());
            if (found.isEmpty()) {
                shoppingItems.add(ingredient);
            } else {
                Ingredient foundIngredient = found.get();
                foundIngredient.setAmount(foundIngredient.getAmount() + ingredient.getAmount());
            }
        }
    }

    public Optional<Ingredient> findIngredient(String name) {
        return shoppingItems.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst();
    }
}
