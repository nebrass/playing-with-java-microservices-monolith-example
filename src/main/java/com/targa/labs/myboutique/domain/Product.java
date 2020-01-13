package com.targa.labs.myboutique.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.targa.labs.myboutique.domain.enumeration.ProductStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A Product.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends AbstractEntity {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ProductStatus status;

    @Column(name = "sales_counter")
    private Integer salesCounter;

    @OneToMany
    @JsonIgnore
    private Set<Review> reviews = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(@NotNull String name, @NotNull String description, @NotNull BigDecimal price,
                   Integer salesCounter, Set<Review> reviews, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.salesCounter = salesCounter;
        this.reviews = reviews;
        this.category = category;
    }

    public Product(@NotNull String name, @NotNull String description, @NotNull BigDecimal price,
                   ProductStatus status, Integer salesCounter, Set<Review> reviews, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.salesCounter = salesCounter;
        this.reviews = reviews;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                status == product.status &&
                Objects.equals(salesCounter, product.salesCounter) &&
                Objects.equals(reviews, product.reviews) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, status, salesCounter, reviews, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", salesCounter=" + salesCounter +
                ", reviews=" + reviews +
                ", category=" + category +
                '}';
    }
}
