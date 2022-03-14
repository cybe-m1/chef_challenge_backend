CREATE TABLE IF NOT EXISTS stock (
  id_stock INT PRIMARY KEY AUTO_INCREMENT,
  id_user INT(50),
  id_ingredient INT(50),
  quantity INT(50)
);