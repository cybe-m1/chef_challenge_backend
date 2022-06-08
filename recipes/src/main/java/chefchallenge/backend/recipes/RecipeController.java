package chefchallenge.backend.recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    public List<Recipe> getListRecipe(){
        return recipeService.getAllRecipe();
    }

    @GetMapping("/{id_recipe}")
    public Recipe getRecipeById(@PathVariable int id_recipe){
        return recipeService.getRecipe(id_recipe);
    }

    @GetMapping("/search/{name_ingredient}")
    public List<Recipe> getIngredientByName(@PathVariable String name_recipe){
        return recipeService.getRecipeByName(name_recipe);
    }

    @PutMapping
    public Recipe modifyRecipe(@RequestBody Recipe recipe) {
        return recipeService.modifyRecipe(recipe);
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @DeleteMapping("/{id_recipe}")
    public String deleteRecipe(@PathVariable int id_recipe) {
        return recipeService.deleteRecipe(id_recipe);
    }
}
