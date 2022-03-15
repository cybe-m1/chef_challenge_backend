package chefchallenge.backend.ingredients;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {
    private final IngredientsRepository ingredientsRepository;

    public IngredientsService(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    public List<Ingredient> getAllIngredient() {
        return ingredientsRepository.findAll();
    }

    public Ingredient getIngredient(int id_user) {
        return ingredientsRepository.getById(id_user);
    }

    public List<Ingredient> getIngredientByName(String name_Ingredient) {
        return ingredientsRepository.findByNameContaining(name_Ingredient);
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        if (ingredientsRepository.existsById(ingredient.getId_ingredient())) {
            throw new IllegalArgumentException("Id " + ingredient.getId_ingredient() + " already used");
        } else {
            return ingredientsRepository.save(ingredient);
        }
    }

    public Ingredient modifyIngredient(Ingredient ingredient) {
        if (ingredientsRepository.existsById(ingredient.getId_ingredient())) {
            return ingredientsRepository.save(ingredient);
        } else {
            throw new IllegalArgumentException("Id: " + ingredient.getId_ingredient() + " not found");
        }
    }

    public String suppIngredient(int id_ingredient) {
        if (ingredientsRepository.existsById(id_ingredient)) {
            Ingredient ingredientToDelete = ingredientsRepository.getById(id_ingredient);
            ingredientsRepository.delete(ingredientToDelete);
            return "Ingredient deleted";
        } else {
            return "Id: " + id_ingredient + " dosen't exist";
        }
    }
}
