CREATE TABLE shop (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    identifier VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    date_shop DATE
);

CREATE TABLE shop_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_identifier VARCHAR(100) NOT NULL,
    amount INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL, -- Usando DECIMAL para precisão monetária
    shop_id BIGINT NOT NULL REFERENCES shop(id) ON DELETE CASCADE
);
