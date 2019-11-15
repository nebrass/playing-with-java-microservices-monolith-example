package com.targa.labs.myboutique.web.dto;

/**
 * @author Nebrass Lamouchi
 */
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private Integer products;

    public CategoryDto() {
        // JACKSON
    }

    public CategoryDto(Long id, String name, String description, Integer products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
    }

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

    public Integer getProducts() {
        return products;
    }

    public void setProducts(Integer products) {
        this.products = products;
    }
}
