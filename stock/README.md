## 📦 Stock

_Stock service of the Chef Challenge project._

**Run on port :** 8082

### Scheme of the object stock

```json
{
  "id_stock": "generated auto",
  "id_user": "id of the user",
  "id_ingredient": "id of the ingredient",
  "quantity": "number of ingredient the user"
}
```

### The route for ingredient service

Get a list of ingredient :  
method : **[GET]**  
url : `localhost:8082/api/stock`

Get a list of ingredient based on the name who look like :  
method : **[GET]**  
url : `localhost:8082/api/stock/search/{nameOfChallenge}`

Get one ingredient by id :  
method : **[GET]**  
url : `localhost:8082/api/stock/{idStock}`

Modify one ingredient  
method : **[PUT]**   
url : `localhost:8082/api/stock`  
Body :
```json
{
    "id_stock": "needed to change the stock",
    "id_user": "id of the user",
    "id_ingredient": "id of the ingredient",
    "quantity": "number of ingredient the user"
}
```

For add a ingredient :  
method : **[POST]**  
url : `localhost:8082/api/stock`  
Body:
> No need to put an id

```json
{
  "id_user": "id of the user",
  "id_ingredient": "id of the ingredient",
  "quantity": "number of ingredient the user"
}
```

For erase a ingredient :  
method : **[DELETE]**  
url : `localhost:8082/api/stock/{idStock}`  
