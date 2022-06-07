## 📙 Recipes

_Recipes service of the Chef Challenge project._

**Run on port :** 8084

### Scheme of the object recipes

```json
{
  "id_recipe": "generated auto",
  "name": "Name of the recipe"
}
```

### The route for recipes service

Get a list of all recipes :  
method : **[GET]**  
url : `localhost:8084/api/recipe`

Get a list a recipe from name :  
method : **[GET]**  
url : `localhost:8084/api/recipe/search/{nameOfRecipe}`

Get recipe by ID :  
method : **[GET]**  
url : `localhost:8084/api/recipe/{idrecipe}`

Update a recipe  
method : **[PUT]**   
url : `localhost:8084/api/recipe`  
Body :
```json
{
    "id_recipe": "needed to change the recipe", 
    "name": "The new value"
}
```

Add a new recipe :  
method : **[POST]**  
url : `localhost:8084/api/recipe`  
Body:  
```json
{
  "name": "name of your recipe"
}
```

Erase a recipe :  
method : **[DELETE]**  
url : `localhost:8084/api/recipe/{idRecipe}`  
