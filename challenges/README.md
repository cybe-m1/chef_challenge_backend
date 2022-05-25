## 🏆 Challenges

_Challenges service of the Chef Challenge project._

**Run on port :** 8085

### Scheme of the object challenge

```json
{
  "id_challenge": "generated auto",
  "name": "Name of the challenge"
}
```

### The route for challenge service

Get a list of challenge :  
method : **[GET]**  
url : `localhost:8085/api/challenge`  

Get a list of challenge based on the name who look like :  
method : **[GET]**  
url : `localhost:8085/api/challenge/search/{nameOfChallenge}`  

Get one challenge by id :  
method : **[GET]**  
url : `localhost:8085/api/challenge/{idChallenge}`  

Modify one challenge  
method : **[PUT]**   
url : `localhost:8085/api/challenge`  
Body :  
```json
{
    "id_challenge": "needed to change the challenge", 
    "name": "The new value"
}
```

For add a challenge :  
method : **[POST]**  
url : `localhost:8085/api/challenge`  
Body:  
> No need to put an id

```json
{
  "name": "name of your challenge"
}
```

For erase a challenge :  
method : **[DELETE]**  
url : `localhost:8085/api/challenge/{idChallenge}`  
