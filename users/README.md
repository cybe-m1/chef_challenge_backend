## 👥 Users

_User service of the Chef Challenge project._

### Scheme of the object User

```json
{
  "id_user": "generated auto",
  "first_name": "first name of the user",
  "last_name": "last name of the user",
  "email": "email of the user",
  "pseudo": "Pseudo of the user",
  "password": "password",
  "urlPicture": "url of the picture of the user"
}
```

### The route for user service

Get a list of user :  
method : **[GET]**  
url : `localhost:8081/api/user`  

Get a list of ingredient based on the name who look like :  
method : **[GET]**  
url : `localhost:8081/api/user/{idUser}`  

Modify one user   
method : **[PUT]**   
url : `localhost:8081/api/user`  
Body :  
```json
{
  "id_user": "generated auto",
  "first_name": "first name of the user",
  "last_name": "last name of the user",
  "email": "email of the user",
  "pseudo": "Pseudo of the user",
  "password": "password",
  "urlPicture": "url of the picture of the user"
}
```

For add a user :  
method : **[POST]**  
url : `localhost:8081/api/user`  
Body:  
> No need to put an id
```json
{
  "first_name": "first name of the user",
  "last_name": "last name of the user",
  "email": "email of the user",
  "pseudo": "Pseudo of the user",
  "password": "password",
  "urlPicture": "url of the picture of the user"
}
```

For erase a user :  
method : **[DELETE]**  
url : `localhost:8081/api/user/{idUser}`  