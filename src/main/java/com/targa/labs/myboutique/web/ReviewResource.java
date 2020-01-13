package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.ReviewService;
import com.targa.labs.myboutique.web.dto.ReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.common.Web.API;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/reviews")
public class ReviewResource {

    private final ReviewService reviewService;

    public ReviewResource(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDto> findAll() {
        return this.reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable Long id) {
        return this.reviewService.findById(id);
    }

    @PostMapping
    public ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return this.reviewService.createDto(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.reviewService.delete(id);
    }
}
