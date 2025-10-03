-- Insert categories (IDs will be 1, 2, 3, 4)
INSERT INTO category (id, name, description)
VALUES
    (nextval('category_seq'), 'Electronics', 'Devices and gadgets'),
    (nextval('category_seq'), 'Books', 'Educational and leisure reading materials'),
    (nextval('category_seq'), 'Clothing', 'Men and Women apparel'),
    (nextval('category_seq'), 'Furniture', 'Home and Office furniture');

-- Insert products linked to categories (1=Electronics, 2=Books, 3=Clothing, 4=Furniture)
INSERT INTO product (id, name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Smartphone', 'Latest Android smartphone', 50, 699.99, 1),
    (nextval('product_seq'), 'Laptop', 'High-performance laptop', 20, 1299.49, 1),
    (nextval('product_seq'), 'Novel', 'Bestselling fiction book', 100, 19.99, 2),
    (nextval('product_seq'), 'Textbook', 'Computer Science textbook', 40, 89.50, 2),
    (nextval('product_seq'), 'T-Shirt', 'Cotton t-shirt', 200, 14.99, 3),
    (nextval('product_seq'), 'Jeans', 'Slim fit denim jeans', 150, 39.90, 3),
    (nextval('product_seq'), 'Office Chair', 'Ergonomic office chair', 30, 249.00, 4),
    (nextval('product_seq'), 'Dining Table', 'Wooden dining table', 10, 599.99, 4);
