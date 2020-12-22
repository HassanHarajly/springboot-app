CREATE TABLE shop_information (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  shop_name VARCHAR(100) NOT NULL,
  shop_street_address VARCHAR(100) NOT NULL,
  shop_zip VARCHAR(10) NOT NULL,
  shop_state VARCHAR(30) NOT NULL
);

CREATE TABLE product_information (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  shop_id INT NOT NULL,
  product_name VARCHAR(100) NOT NULL,
  product_quantity INT NOT NULL,
  product_barcode VARCHAR(100) DEFAULT NULL,
  product_price INT DEFAULT NULL
);

INSERT INTO product_information (shop_id, product_name, product_quantity, product_barcode,product_price) VALUES
  (1, 'water bottle', 100,'0012612',50),
   (2, 'computer', 100,'0012312',1000),
      (3, 'mouse', 100,'5512312',2000);


INSERT INTO shop_information (shop_name, shop_street_address, shop_zip, shop_state) VALUES
  ('hassans-store', '111 main st', '48127','MI'),
    ('hassans-store1', '222 main st', '48126','ohio'),
    ('hassans-store', '333 main st', '48125','new york');
