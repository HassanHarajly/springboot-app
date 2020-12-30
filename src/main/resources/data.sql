DROP TABLE shop_information;
CREATE TABLE shop_information (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  shop_name VARCHAR(100) NOT NULL,
  shop_street_address VARCHAR(100) NOT NULL,
  shop_zip VARCHAR(10) NOT NULL,
  shop_state VARCHAR(30) NOT NULL,
  SHOP_LATITUDE DOUBLE NOT NULL,
  SHOP_LONGITUDE DOUBLE NOT NULL
);

CREATE TABLE product_information (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  shop_id INT NOT NULL,
  product_name VARCHAR(100) NOT NULL,
  product_quantity INT NOT NULL,
  product_barcode VARCHAR(100) DEFAULT NULL,
  product_price INT DEFAULT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL
);

INSERT INTO product_information (shop_id, product_name, product_quantity, product_barcode,product_price,latitude,longitude) VALUES
  (1, 'water bottle', 100,'0012612',50,42.345916365908124, -83.16365162629968),
  (2, 'computer', 100,'0012312',1000,42.37081942915661, -83.33668833120687),
  (3, 'mouse', 100,'5512312',2000,41.59716263210701, -83.5566008257482);


-- INSERT INTO shop_information (shop_name, shop_street_address, shop_zip, shop_state, SHOP_LATITUDE, SHOP_LONGITUDE)VALUES
--   ('hassans-store', '111 main st', '48127','MI',42.345916365908124, -83.16365162629968),
--   ('kmart', '222 main st', '48126','ohio',42.37081942915661, -83.33668833120687),
--   ('target', '333 main st', '48125','new york',41.59716263210701, -83.5566008257482),
--   ('walmart', '111 main st', '48127','MI',41.59716263210701, -83.5566008257482);

