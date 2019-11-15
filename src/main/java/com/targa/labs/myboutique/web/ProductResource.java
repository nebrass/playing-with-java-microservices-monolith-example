package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.ProductService;
import com.targa.labs.myboutique.web.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.common.Web.API;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/products")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return this.productService.findById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return this.productService.create(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.productService.delete(id);
    }
}
