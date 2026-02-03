package com.brickworld.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Double price;

    @Column(name = "pieces_count")
    private Integer piecesCount;

    @Column(name = "age_from")
    private Integer ageFrom;

    @Column(name = "image_url")
    private String imageUrl;

    // Связь с категорией
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Конструкторы
    public Product() {
    }

    public Product(String name, String description, Double price, Integer piecesCount, Integer ageFrom, String imageUrl, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.piecesCount = piecesCount;
        this.ageFrom = ageFrom;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPiecesCount() {
        return piecesCount;
    }

    public void setPiecesCount(Integer piecesCount) {
        this.piecesCount = piecesCount;
    }

    public Integer getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
