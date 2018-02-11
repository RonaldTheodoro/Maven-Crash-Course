package br.com.app.product.bo;

import br.com.app.product.dao.ProductDAO;
import br.com.app.product.dto.Product;

public class ProductBOImpl implements ProductBO {
    private ProductDAO dao;

    @Override
    public void create(Product product) {
        dao.create(product);
    }

    @Override
    public Product findProduct(int id) {
        return dao.read(id);
    }

    public ProductDAO getDao() {
        return dao;
    }

    public void setDao(ProductDAO dao) {
        this.dao = dao;
    }

}