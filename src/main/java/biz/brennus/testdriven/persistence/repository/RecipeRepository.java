package biz.brennus.testdriven.persistence.repository;

import biz.brennus.testdriven.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
