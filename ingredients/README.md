## 🥕 Ingredients

_Ingredients service of the Chef ingredient project._

**Run on port :** 8083

### Scheme of the object ingredient

```json
{
  "id_ingredient": "generated auto",
  "name": "Name of the ingredient"
}
```

### The route for ingredient service

Get a list of all ingredients :  
method : **[GET]**  
url : `localhost:8083/ingredient`

Get a list of ingredient based on the name who look like :  
method : **[GET]**  
url : `localhost:8083/api/ingredient/search/{nameOfIngredient}`

Get one ingredient by id :  
method : **[GET]**  
url : `localhost:8083/api/ingredient/{id_ingredient}`

Modify one ingredient  
method : **[PUT]**   
url : `localhost:8083/api/ingredient`  
Body :
```json
{
    "id_ingredient": "needed to change the ingredient", 
    "name": "The new value"
}
```

For add a ingredient :  
method : **[POST]**  
url : `localhost:8083/api/ingredient`  
Body:
> No need to put an id</br>

```json
{
  "name": "name of your ingredient"
}
```

For erase a ingredient :  
method : **[DELETE]**  
url : `localhost:8083/api/ingredient/{idIngredient}`  
