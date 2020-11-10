package services;

import model.ProductRequest;
import model.ProductResponse;
import org.springframework.stereotype.Service;
import repository.ProductRepositoryImpl;
import repository.entity.Product;

import javax.ws.rs.NotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepositoryImpl repository;

    public ProductService(ProductRepositoryImpl repository) {
        this.repository = repository;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = repository.create(request);
        return from(product);
    }
    public List<ProductResponse> fetchBy(String category) throws NotFoundException {
        List<Product> products = (List<Product>) repository.findByCategory(category);
        return products.stream().map(this::from).collect(Collectors.toList());

    }

    private ProductResponse from(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setBrand(product.getBrand());
        response.setCategory(product.getCategory());
        response.setCreatedAt(product.getCategory());
        response.setTags(splitTags(product.getTags()));
        return response;
    }

    private List<String> splitTags(String tags) {
       return Arrays.asList(tags.split(","));
    }
}
