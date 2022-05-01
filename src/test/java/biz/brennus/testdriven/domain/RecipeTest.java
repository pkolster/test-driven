package biz.brennus.testdriven.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RecipeTest {

    @Test
    public void shouldAddIngredient() {
        // Given
        Recipe chlebaSMaslom = new Recipe("Chleba s maslom");
        Ingredient chlieb = new Ingredient("chlieb", 0.1, "ks");
        Ingredient maslo = new Ingredient("maslo", 0.05, "ks");
        // When
        chlebaSMaslom.addIngredient(chlieb);
        chlebaSMaslom.addIngredient(maslo);
        // Then
        assertThat(chlebaSMaslom.getIngredientList()).contains(chlieb);
        assertThat(chlebaSMaslom.getIngredientList()).contains(maslo);
    }
}
