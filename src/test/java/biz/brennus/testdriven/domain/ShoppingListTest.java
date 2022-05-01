package biz.brennus.testdriven.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ShoppingListTest {

    @Test
    public void shouldAddIngredientsFromRecipeToShoppingList() {
        // Given
        Recipe palacinky = new Recipe("Palacinky");
        Ingredient vajcia = new Ingredient("vajce", 2, "ks");
        palacinky.addIngredient(vajcia);
        ShoppingList shoppingList = new ShoppingList();
        // When
        shoppingList.addRecipe(palacinky);
        // Then
        assertThat(shoppingList.getShoppingItems()).contains(vajcia);
    }

    @Test
    public void shouldCreateShoppingListFromSelectedRecipes() {
        // Given
        ShoppingList shoppingList = new ShoppingList();
        Recipe kulajda = new Recipe("Kulajda");
        Ingredient huby = new Ingredient("huby", 1, "sáčok");
        kulajda.addIngredient(huby);
        Recipe vyprazanySyr = new Recipe("Vyprážaný syr");
        Ingredient syr = new Ingredient("syr", 4, "ks");
        vyprazanySyr.addIngredient(syr);
        // When
        shoppingList.addRecipe(kulajda);
        shoppingList.addRecipe(vyprazanySyr);
        // Then
        assertThat(shoppingList.getShoppingItems()).contains(huby);
        assertThat(shoppingList.getShoppingItems()).contains(syr);
    }

    @Test
    public void shouldSumUpTheIngredientAmountsInCauseOfSameIngredients() {
        // Given
        ShoppingList shoppingList = new ShoppingList();

        Ingredient kuraciePrsia100g = new Ingredient("kuracie prsia", 100, "g");
        Ingredient kuraciePrsia200g = new Ingredient("kuracie prsia", 200, "g");

        Recipe chickenKorma = new Recipe("Chicken korma");
        chickenKorma.addIngredient(kuraciePrsia100g);

        Recipe kuraNaCitronovejTrave = new Recipe("Kura na citrónovej tráve");
        kuraNaCitronovejTrave.addIngredient(kuraciePrsia200g);

        // When
        shoppingList.addRecipe(chickenKorma);
        shoppingList.addRecipe(kuraNaCitronovejTrave);

        // Then
        Ingredient kuraciePrsiaSum = shoppingList.getShoppingItems().get(0);
        assertThat(kuraciePrsiaSum.getAmount()).isEqualTo(300);
    }

}
