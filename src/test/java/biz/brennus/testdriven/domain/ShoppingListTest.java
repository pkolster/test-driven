package biz.brennus.testdriven.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ShoppingListTest {

    @Test
    public void shouldAddIngredientsFromRecipeToShoppingList() {
        // Given
        Recipe palacinky = new Recipe("Palacinky");
        Ingredient vajce = new Ingredient("vajce", "ks");
        palacinky.addIngredient(vajce, 2);
        ShoppingList shoppingList = new ShoppingList();
        // When
        shoppingList.addRecipe(palacinky);
        // Then
        assertThat(shoppingList.getShoppingItems().get(0).getIngredient()).isEqualTo(vajce);
        assertThat(shoppingList.getShoppingItems().get(0).getAmount()).isEqualTo(2);
    }

    @Test
    public void shouldCreateShoppingListFromSelectedRecipes() {
        // Given
        ShoppingList shoppingList = new ShoppingList();
        Recipe kulajda = new Recipe("Kulajda");
        Ingredient huby = new Ingredient("huby", "sáčok");
        kulajda.addIngredient(huby, 1);
        Recipe vyprazanySyr = new Recipe("Vyprážaný syr");
        Ingredient syr = new Ingredient("syr", "ks");
        vyprazanySyr.addIngredient(syr, 4);
        // When
        shoppingList.addRecipe(kulajda);
        shoppingList.addRecipe(vyprazanySyr);
        // Then
        assertThat(shoppingList.getShoppingItems().get(0).getIngredient()).isEqualTo(huby);
        assertThat(shoppingList.getShoppingItems().get(1).getIngredient()).isEqualTo(syr);
    }

    @Test
    public void shouldSumUpTheIngredientAmountsInCauseOfSameIngredients() {
        // Given
        ShoppingList shoppingList = new ShoppingList();

        Ingredient kuraciePrsia = new Ingredient("kuracie prsia", "g");

        Recipe chickenKorma = new Recipe("Chicken korma");
        chickenKorma.addIngredient(kuraciePrsia, 100);

        Recipe kuraNaCitronovejTrave = new Recipe("Kura na citrónovej tráve");
        kuraNaCitronovejTrave.addIngredient(kuraciePrsia, 200);

        // When
        shoppingList.addRecipe(chickenKorma);
        shoppingList.addRecipe(kuraNaCitronovejTrave);

        // Then
        IngredientOfRecipe kuraciePrsiaSum = shoppingList.getShoppingItems().get(0);
        assertThat(kuraciePrsiaSum.getAmount()).isEqualTo(300);
    }

}
