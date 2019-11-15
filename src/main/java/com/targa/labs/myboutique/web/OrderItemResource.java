package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.OrderItemService;
import com.targa.labs.myboutique.web.dto.OrderItemDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.common.Web.API;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/order-items")
public class OrderItemResource {

    private final OrderItemService itemService;

    public OrderItemResource(OrderItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<OrderItemDto> findAll() {
        return this.itemService.findAll();
    }

    @GetMapping("/{id}")
    public OrderItemDto findById(@PathVariable Long id) {
        return this.itemService.findById(id);
    }

    @PostMapping
    public OrderItemDto create(@RequestBody OrderItemDto orderItemDto) {
        return this.itemService.create(orderItemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.itemService.delete(id);
    }
}
