## 🥕 Ingredients

_Ingredients service of the Chef Challenge project._

**Run on port :** 8083

### Scheme of the object ingredient

```json
{
  "id_challenge": "generated auto",
  "name": "Name of the challenge"
}
```

### The route for ingredient service

Get a list of ingredient :  
method : **[GET]**  
url : `localhost:8083/api/challenge`

Get a list of ingredient based on the name who look like :  
method : **[GET]**  
url : `localhost:8083/api/challenge/search/{nameOfChallenge}`

Get one ingredient by id :  
method : **[GET]**  
url : `localhost:8083/api/challenge/{idChallenge}`

Modify one ingredient  
method : **[PUT]**   
url : `localhost:8083/api/challenge`  
Body :
```json
{
    "id_ingredient": "needed to change the ingredient", 
    "name": "The new value"
}
```

For add a ingredient :  
method : **[POST]**  
url : `localhost:8083/api/challenge`  
Body:
> No need to put an id</br>

```json
{
  "name": "name of your challenge"
}
```

For erase a ingredient :  
method : **[DELETE]**  
url : `localhost:8083/api/challenge/{idIngredient}`  
