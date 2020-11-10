package repository;


import repository.entity.Product;

public interface ProductRepository {

    Product findByCategory(String category);
    Product create(model.ProductRequest productRequest);
}
