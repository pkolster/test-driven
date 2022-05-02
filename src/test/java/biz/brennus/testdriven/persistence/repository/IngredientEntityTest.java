package biz.brennus.testdriven.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import biz.brennus.testdriven.domain.Ingredient;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IngredientEntityTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void shouldNotAllowToStoreIngredientWithoutName() {
        // Given
        Ingredient ingredient = new Ingredient();
        assertThatThrownBy(() -> {
            // When
            ingredientRepository.save(ingredient);
            // Then exception is thrown
        });
    }

    @Test
    public void shouldSaveIngredient() {
        // Given
        Ingredient muka = new Ingredient("múka");
        // When
        ingredientRepository.save(muka);
        // Then
        assertThat(muka.getId()).isNotNull();
    }

    @Test
    public void shouldNotAllowToSaveTwoIngredientsWithSameName() {
        // Given
        Ingredient bazalka1 = new Ingredient("bazalka");
        Ingredient bazalka2 = new Ingredient("bazalka");
        ingredientRepository.save(bazalka1);
        assertThatThrownBy(() -> {
            // When
            ingredientRepository.save(bazalka2);
            // Then exception is thrown
        });
    }

    @Test
    public void shouldFindIngredientByName() {
        // Given
        Ingredient cierneKorenie = new Ingredient("čierne korenie");
        ingredientRepository.save(cierneKorenie);
        // When
        Optional<Ingredient> found = ingredientRepository.findByName("čierne korenie");
        // Then
        assertThat(found).isPresent();
        assertThat(found.get()).isEqualTo(cierneKorenie);
    }
}
