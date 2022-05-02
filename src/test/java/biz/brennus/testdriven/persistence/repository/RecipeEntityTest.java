package biz.brennus.testdriven.persistence.repository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

import biz.brennus.testdriven.domain.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeEntityTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void shouldNotAllowToSaveRecipeWithoutName() {
        // Given
        Recipe noname = new Recipe();
        assertThatThrownBy(() -> {
            // When
            recipeRepository.save(noname);
            // Then throw exception
        });
    }

    @Test
    public void shouldNotAllowToSaveTwoRecipesWithSameName() {
        // Given
        Recipe biftek1 = new Recipe("Tatársky biftek");
        Recipe biftek2 = new Recipe("Tatársky biftek");
        recipeRepository.save(biftek1);

        assertThatThrownBy(() -> {
            // When
            recipeRepository.save(biftek2);
            // Then throw exception
        });
    }

    @Test
    public void shouldSaveRecipeWithIngredients() {
        fail("To be implemented");
    }
}
