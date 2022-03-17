CREATE TABLE IF NOT EXISTS user (
  id_user INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  email VARCHAR(100),
  pseudo VARCHAR(50),
  password VARCHAR(50),
  url_picture VARCHAR(200),
  CONSTRAINT UK_User UNIQUE (id_user,email)
);
