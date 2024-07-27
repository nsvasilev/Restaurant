CREATE TABLE IF NOT EXISTS order_details (
    id SERIAL PRIMARY KEY,
     order_status VARCHAR(255) NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL
    );

-- Создание таблицы Product
CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    available BOOLEAN NOT NULL
    );

-- Создание таблицы ProductCategory
CREATE TABLE IF NOT EXISTS product_categories (
     id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL
    );

-- Создание таблицы для связи Product и ProductCategory
CREATE TABLE IF NOT EXISTS product_category_product (
  product_id INT REFERENCES products(id),
    product_category_id INT REFERENCES product_categories(id),
    PRIMARY KEY (product_id, product_category_id)
    );

-- Создание таблицы для связи OrderDetail и Products
CREATE TABLE IF NOT EXISTS order_detail_products (
     order_detail_id INT REFERENCES order_details(id),
    product_id INT REFERENCES products(id),
    quantity INT NOT NULL,
    PRIMARY KEY (order_detail_id, product_id)
    );

CREATE TABLE IF NOT EXISTS order_approval (
  id BIGSERIAL PRIMARY KEY,
  order_detail_id BIGINT NOT NULL,
  CONSTRAINT fk_order_approval_order_detail FOREIGN KEY (order_detail_id) REFERENCES order_details(id)
    );
