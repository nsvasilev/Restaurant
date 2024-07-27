-- Вставка данных в таблицу products
INSERT INTO products (name, price, quantity, available) VALUES
                                                            ('Pizza Margherita', 12.99, 20, true),
                                                            ('Spaghetti Bolognese', 14.99, 25, true),
                                                            ('Tiramisu', 6.99, 15, true),
                                                            ('Fettuccine Alfredo', 13.99, 22, true),
                                                            ('Lasagna', 11.99, 18, true),
                                                            ('Garlic Bread', 4.99, 30, true),
                                                            ('Caesar Salad', 7.99, 28, true),
                                                            ('Chicken Parmesan', 15.99, 24, true),
                                                            ('Vegetable Stir Fry', 12.99, 20, true),
                                                            ('Seafood Pasta', 17.99, 18, true);

-- Вставка данных в таблицу product_categories
INSERT INTO product_categories (name, type) VALUES
                                                ('Drinks', 'Beverage'),
                                                ('Starters', 'Appetizer'),
                                                ('Salads', 'Side Dish'),
                                                ('Main Courses', 'Main Course'),
                                                ('Appetizers', 'Appetizer');

-- Вставка данных в таблицу product_category_product
INSERT INTO product_category_product (product_id, product_category_id) VALUES
                                                                           (1, 1), (2, 1), (3, 2), (4, 3), (5, 4), (6, 5), (7, 6), (8, 3), (9, 4), (10, 3);

-- Вставка данных в таблицу order_details
INSERT INTO order_details (order_status, total_amount) VALUES
                                                           ('Pending', 60.96),
                                                           ('Completed', 89.94),
                                                           ('Cancelled', 0.00),
                                                           ('Completed', 45.97),
                                                           ('Pending', 74.95),
                                                           ('Completed', 62.93),
                                                           ('Completed', 38.98),
                                                           ('Pending', 67.96),
                                                           ('Completed', 83.92),
                                                           ('Cancelled', 0.00);

-- Вставка данных в таблицу order_detail_products
INSERT INTO order_detail_products (order_detail_id, product_id, quantity) VALUES
                                                                              (1, 1, 5), (2, 2, 2), (3, 3, 1), (4, 4, 3), (5, 6, 1), (6, 7, 1), (7, 8, 2), (8, 9, 1), (9, 10, 1), (10, 11, 1);

-- Вставка данных в таблицу order_approval
INSERT INTO order_approval (order_detail_id, approved_by) VALUES
                                                              (1, 'Chef Giovanni'), (2, 'Manager Maria'), (3, 'Waiter Luca'), (4, 'Chef Giovanni'), (5, 'Manager Maria'), (6, 'Chef Giovanni'), (7, 'Manager Maria'), (8, 'Waiter Luca'), (9, 'Chef Giovanni'), (10, 'Manager Maria');
