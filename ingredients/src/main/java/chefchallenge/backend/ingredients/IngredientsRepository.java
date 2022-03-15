package chefchallenge.backend.ingredients;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByNameContaining(String name);
}
