package chefchallenge.backend.recipes;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipe() {
        return recipeRepository.findAll();
    }

    public Recipe getRecipe(int id_recipe) {
        return recipeRepository.getById(id_recipe);
    }

    public List<Recipe> getRecipeByName(String name_recipe) {
        return recipeRepository.findByNameContaining(name_recipe);
    }

    public Recipe addRecipe(Recipe recipe) {
        if (recipeRepository.existsById(recipe.getId_recipe())) {
            throw new IllegalArgumentException("Id " + recipe.getId_recipe() + " already used");
        } else {
            return recipeRepository.save(recipe);
        }
    }

    public Recipe modifyRecipe(Recipe recipe) {
        if (recipeRepository.existsById(recipe.getId_recipe())) {
            return recipeRepository.save(recipe);
        } else {
            throw new IllegalArgumentException("Id: " + recipe.getId_recipe() + " not found");
        }
    }

    public String deleteRecipe(int id_recipe) {
        if (recipeRepository.existsById(id_recipe)) {
            Recipe recipeToDelete = recipeRepository.getById(id_recipe);
            recipeRepository.delete(recipeToDelete);
            return "Ingredient deleted";
        } else {
            return "Id: " + id_recipe + " dosen't exist";
        }
    }
}
