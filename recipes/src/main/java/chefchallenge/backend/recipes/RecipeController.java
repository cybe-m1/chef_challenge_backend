package chefchallenge.backend.recipes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getListIngredient(){
        return recipeService.getAllRecipe();
    }

    @GetMapping("/{id_recipe}")
    public Recipe getIngredientById(@PathVariable int id_recipe){
        return recipeService.getRecipe(id_recipe);
    }

    @GetMapping("/search/{name_ingredient}")
    public List<Recipe> getIngredientByName(@PathVariable String name_recipe){
        return recipeService.getRecipeByName(name_recipe);
    }

    @PutMapping
    public Recipe modifyIngredient(@RequestBody Recipe recipe) {
        return recipeService.modifyRecipe(recipe);
    }

    @PostMapping
    public Recipe addIngredient(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @DeleteMapping("/{id_recipe}")
    public String deleteRecipe(@PathVariable int id_recipe) {
        return recipeService.deleteRecipe(id_recipe);
    }
}