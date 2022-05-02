package biz.brennus.testdriven.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RecipeTest {

    @Test
    public void shouldAddIngredient() {
        // Given
        Recipe chlebaSMaslom = new Recipe("Chleba s maslom");
        Ingredient chlieb = new Ingredient("chlieb", "ks");
        Ingredient maslo = new Ingredient("maslo", "ks");
        // When
        chlebaSMaslom.addIngredient(chlieb, 0.1);
        chlebaSMaslom.addIngredient(maslo, 0.05);
        // Then
        assertThat(chlebaSMaslom.getIngredientList().get(0).getIngredient()).isEqualTo(chlieb);
        assertThat(chlebaSMaslom.getIngredientList().get(1).getIngredient()).isEqualTo(maslo);
    }
}
