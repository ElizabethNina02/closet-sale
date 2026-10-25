-- 1. Categoría: Camisas y Blusas
IF NOT EXISTS (SELECT 1 FROM categories WHERE nombre = 'Camisas y Blusas')
BEGIN
    INSERT INTO categories (id, nombre) VALUES (NEWID(), 'Camisas y Blusas');
END
GO

-- 2. Categoría: Pantalones y Jeans
IF NOT EXISTS (SELECT 1 FROM categories WHERE nombre = 'Pantalones y Jeans')
BEGIN
    INSERT INTO categories (id, nombre) VALUES (NEWID(), 'Pantalones y Jeans');
END
GO

-- 3. Categoría: Vestidos y Faldas
IF NOT EXISTS (SELECT 1 FROM categories WHERE nombre = 'Vestidos y Faldas')
BEGIN
    INSERT INTO categories (id, nombre) VALUES (NEWID(), 'Vestidos y Faldas');
END
GO

-- 4. Categoría: Casacas y Abrigos
IF NOT EXISTS (SELECT 1 FROM categories WHERE nombre = 'Casacas y Abrigos')
BEGIN
    INSERT INTO categories (id, nombre) VALUES (NEWID(), 'Casacas y Abrigos');
END
GO

-- 5. Categoría: Zapatos y Zapatillas
IF NOT EXISTS (SELECT 1 FROM categories WHERE nombre = 'Zapatos y Zapatillas')
BEGIN
    INSERT INTO categories (id, nombre) VALUES (NEWID(), 'Zapatos y Zapatillas');
END
GO

-- 6. Categoría: Accesorios y Bolsos
IF NOT EXISTS (SELECT 1 FROM categories WHERE nombre = 'Accesorios y Bolsos')
BEGIN
    INSERT INTO categories (id, nombre) VALUES (NEWID(), 'Accesorios y Bolsos');
END
GO
