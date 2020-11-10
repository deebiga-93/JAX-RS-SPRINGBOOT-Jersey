package model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ProductResponse {

    private String id;
    private String name;
    private String brand;
    private String description;
    private List<String> tags;
    private String category;
    private Date createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date setCreatedAt(Date createdAt) {
       return this.createdAt = createdAt;
    }

    public void setCreatedAt(String category) {
        LocalDateTime timeStamp;
    }
}
