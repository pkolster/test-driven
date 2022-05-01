package biz.brennus.testdriven.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IngredientTest {

    @Test
    public void shouldIngredientBeEqualByName() {
        // Given
        Ingredient kuraciePrsia100g = new Ingredient("kuracie prsia", 100, "g");
        Ingredient kuraciePrsia200g = new Ingredient("kuracie prsia", 200, "g");
        // Then
        assertThat(kuraciePrsia100g).isEqualTo(kuraciePrsia200g);
    }
}
