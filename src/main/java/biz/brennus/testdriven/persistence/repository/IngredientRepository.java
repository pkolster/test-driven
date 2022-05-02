package biz.brennus.testdriven.persistence.repository;

import biz.brennus.testdriven.domain.Ingredient;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Optional<Ingredient> findByName(String name);
}
