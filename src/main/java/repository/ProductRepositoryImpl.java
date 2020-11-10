package repository;

import model.ProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import repository.entity.Product;

@Repository
public class ProductRepositoryImpl implements repository.ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Product findByCategory(String category) {
        String sql = "SELECT * FROM Product WHERE category = ?";
        return (Product) jdbcTemplate.queryForObject(sql, new Object[]{category}, new BeanPropertyRowMapper<>(Product.class));
    }

    @Override
    public Product create(ProductRequest productRequest) {
        String sql = "INSERT INTO Product(name,brand,description,tags,category)VALUES('RED-T shirt','Hugo-boss','Red T-shirt -hugo boss',{'red Tshirt','Hugo-boss'},'apparel')";
//        ZonedDateTime now = ZonedDateTime.now();
        return (Product) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
}
