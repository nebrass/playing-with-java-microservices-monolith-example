package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.OrderService;
import com.targa.labs.myboutique.web.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.common.Web.API;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/orders")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

    @GetMapping("/customer/{id}")
    public List<OrderDto> findAllByUser(@PathVariable Long id) {
        return this.orderService.findAllByUser(id);
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return this.orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }
}
