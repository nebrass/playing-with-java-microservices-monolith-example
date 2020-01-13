package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.CartService;
import com.targa.labs.myboutique.web.dto.CartDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.common.Web.API;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/carts")
public class CartResource {

    private final CartService cartService;

    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartDto> findAll() {
        return this.cartService.findAll();
    }

    @GetMapping("/active")
    public List<CartDto> findAllActiveCarts() {
        return this.cartService.findAllActiveCarts();
    }

    @GetMapping("/customer/{id}")
    public CartDto getActiveCartForCustomer(@PathVariable("id") Long customerId) {
        return this.cartService.getActiveCart(customerId);
    }

    @GetMapping("/{id}")
    public CartDto findById(@PathVariable Long id) {
        return this.cartService.findById(id);
    }

    @PostMapping("/customer/{id}")
    public CartDto create(@PathVariable("id") Long customerId) {
        return this.cartService.createDto(customerId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.cartService.delete(id);
    }
}
