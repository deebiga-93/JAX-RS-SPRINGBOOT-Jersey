package repository.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;


@Entity
public class Product {
    private String id;
    private String name;
    private String brand;
    private String description;
    private String category;
    private String tags;
    @JsonFormat(shape =  JsonFormat.Shape.STRING, pattern ="yyyy-MM-ddTHH:mm:ss.SSSZ")
    private Date created_at;
public Product(String id, String name, String decathalon, String description, String apparel, String tags, String s){

}
    public Product(String s) {
        this.id=id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.created_at = created_at;
    }
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getId() {
        return id;
    }

    public void setId(String id) {
       this.id = id;
    }
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "Brand", nullable = false)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Column(name = "category", nullable = false)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @Column(name = "tags", nullable = false)
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
       this.tags = tags;
    }
    @Column(name = "created_at", nullable = false)

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
