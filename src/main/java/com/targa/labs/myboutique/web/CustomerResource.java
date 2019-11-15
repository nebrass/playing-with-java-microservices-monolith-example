package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.CustomerService;
import com.targa.labs.myboutique.web.dto.CustomerDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.common.Web.API;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/customers")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDto> findAll() {
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Long id) {
        return this.customerService.findById(id);
    }

    @GetMapping("/active")
    public List<CustomerDto> findAllActive() {
        return this.customerService.findAllActive();
    }

    @GetMapping("/inactive")
    public List<CustomerDto> findAllInactive() {
        return this.customerService.findAllInactive();
    }

    @PostMapping
    public CustomerDto create(CustomerDto customerDto) {
        return this.customerService.create(customerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.customerService.delete(id);
    }
}