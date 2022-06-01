package chefchallenge.backend.ingredients;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/ingredient")
public class IngredientsController {
    private final IngredientsService ingredientsService;

    public IngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @GetMapping
    public List<Ingredient> getListIngredient(){
        return ingredientsService.getAllIngredient();
    }

    @GetMapping("/{id_ingredient}")
    public Ingredient getIngredientById(@PathVariable int id_ingredient){
        return ingredientsService.getIngredient(id_ingredient);
    }

    @GetMapping("/search/{name_ingredient}")
    public List<Ingredient> getIngredientByName(@PathVariable String name_ingredient){
        return ingredientsService.getIngredientByName(name_ingredient);
    }

    @PutMapping
    public Ingredient modifyIngredient(@RequestBody Ingredient ingredient) {
        return ingredientsService.modifyIngredient(ingredient);
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient) {
        return ingredientsService.addIngredient(ingredient);
    }

    @DeleteMapping("/{id_ingredient}")
    public String deleteIngredient(@PathVariable int id_ingredient) {
        return ingredientsService.suppIngredient(id_ingredient);
    }
}
