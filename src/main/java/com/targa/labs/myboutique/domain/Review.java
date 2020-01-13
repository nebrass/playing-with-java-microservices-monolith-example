package com.targa.labs.myboutique.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * A Review.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review extends AbstractEntity {

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Long rating;

    public Review(@NotNull String title, @NotNull String description, @NotNull Long rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(title, review.title) &&
                Objects.equals(description, review.description) &&
                Objects.equals(rating, review.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, rating);
    }

    @Override
    public String toString() {
        return "Review{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
