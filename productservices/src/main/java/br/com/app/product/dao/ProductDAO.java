package br.com.app.product.dao;

import br.com.app.product.dto.Product;

public interface ProductDAO {

    void create(Product product);

    Product read(int id);

    void update(Product product);

    void delete(int id);

}
