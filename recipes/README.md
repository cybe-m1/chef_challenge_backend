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

Get a list of recipes :  
method : **[GET]**  
url : `localhost:8084/api/recipe`

Get a list of recipes based on the name who look like :  
method : **[GET]**  
url : `localhost:8084/api/recipe/search/{nameOfRecipe}`

Get one recipes by id :  
method : **[GET]**  
url : `localhost:8084/api/recipe/{idrecipe}`

Modify one recipes  
method : **[PUT]**   
url : `localhost:8084/api/recipe`  
Body :
```json
{
    "id_recipe": "needed to change the recipe", 
    "name": "The new value"
}
```

For add a recipes :  
method : **[POST]**  
url : `localhost:8084/api/recipe`  
Body:
> No need to put an id

```json
{
  "name": "name of your recipe"
}
```

For erase a recipes :  
method : **[DELETE]**  
url : `localhost:8084/api/recipe/{idRecipe}`  
