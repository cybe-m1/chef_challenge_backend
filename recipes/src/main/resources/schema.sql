CREATE TABLE IF NOT EXISTS recipe (
  id_recipe INT PRIMARY KEY AUTO_INCREMENT,
  id_user INT,
  name VARCHAR(50),
  description VARCHAR(200),
  ingredients VARCHAR(200),
  url VARCHAR(200)
);
