INSERT INTO product_categories (name, type) VALUES
                                                ('Drinks', 'Beverage'),
                                                ('Starters', 'Appetizer'),
                                                ('Soups', 'Appetizer'),
                                                ('Salads', 'Side Dish'),
                                                ('Main Courses', 'Main Course'),
                                                ('Appetizers', 'Appetizer'),
                                                ('Desserts', 'Dessert'),
                                                ('Sides', 'Side Dish'),
                                                ('Special Offers', 'Promotion'),
                                                ('Coffee', 'Beverage'),
                                                ('Italian Specialties', 'Main Course');

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
                                                            ('Seafood Pasta', 17.99, 18, true),
                                                            ('Bruschetta', 5.99, 35, true),
                                                            ('Caprese Salad', 8.99, 27, true),
                                                            ('Risotto', 16.99, 19, true),
                                                            ('Gnocchi', 14.99, 23, true),
                                                            ('Panna Cotta', 7.99, 17, true),
                                                            ('Espresso', 2.99, 50, true),
                                                            ('Americano', 3.99, 45, true),
                                                            ('Latte', 4.99, 40, true),
                                                            ('Cappuccino', 4.99, 42, true),
                                                            ('Mocha', 5.99, 38, true);


INSERT INTO product_category_product (product_id, product_category_id) VALUES
                                                                           (1, 1), (2, 1), (3, 2), (4, 3), (5, 4), (6, 5), (7, 6), (8, 3), (9, 4), (10, 3),
                                                                           (11, 6), (12, 7), (13, 8), (14, 9), (15, 10),
                                                                           (16, 1), (17, 1), (18, 1), (19, 1), (20, 1);


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
                                                           ('Cancelled', 0.00),
                                                           ('Pending', 120.96),
                                                           ('Completed', 159.94),
                                                           ('Cancelled', 75.00),
                                                           ('Completed', 105.97),
                                                           ('Pending', 134.95),
                                                           ('Completed', 122.93),
                                                           ('Completed', 98.98),
                                                           ('Pending', 127.96),
                                                           ('Completed', 143.92),
                                                           ('Cancelled', 85.00);


INSERT INTO order_detail_products (order_detail_id, product_id, quantity) VALUES
                                                                              (1, 1, 5), (2, 2, 2), (3, 3, 1), (4, 4, 3), (5, 6, 1), (6, 7, 1),
                                                                              (7, 8, 2), (8, 9, 1), (9, 10, 1), (10, 11, 1),
                                                                              (11, 11, 3), (12, 12, 4), (13, 13, 2), (14, 14, 1), (15, 15, 2),
                                                                              (16, 16, 1), (17, 17, 2), (18, 18, 3), (19, 19, 1), (20, 20, 2);


-- INSERT INTO order_approval (order_detail_id, approved_by) VALUES
--                                                               (1, 'Chef Giovanni'), (2, 'Manager Maria'), (3, 'Waiter Luca'), (4, 'Chef Giovanni'), (5, 'Manager Maria'),
--                                                               (6, 'Chef Giovanni'), (7, 'Manager Maria'), (8, 'Waiter Luca'), (9, 'Chef Giovanni'), (10, 'Manager Maria'),
--                                                               (11, 'Chef Giovanni'), (12, 'Manager Maria'), (13, 'Waiter Luca'), (14, 'Chef Giovanni'), (15, 'Manager Maria'),
--                                                               (16, 'Chef Giovanni'), (17, 'Manager Maria'), (18, 'Waiter Luca'), (19, 'Chef Giovanni'), (20, 'Manager Maria');

