package br.com.app.product.bo;

import br.com.app.product.dto.Product;

public interface ProductBO {

    void create(Product product);

    Product findProduct(int id);

}
