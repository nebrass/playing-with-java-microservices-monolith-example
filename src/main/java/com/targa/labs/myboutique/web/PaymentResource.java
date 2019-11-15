package com.targa.labs.myboutique.web;

import com.targa.labs.myboutique.service.PaymentService;
import com.targa.labs.myboutique.web.dto.PaymentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.targa.labs.myboutique.common.Web.API;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    public PaymentResource(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<PaymentDto> findAll() {
        return this.paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDto findById(@PathVariable Long id) {
        return this.paymentService.findById(id);
    }

    @PostMapping
    public PaymentDto create(@RequestBody PaymentDto orderItemDto) {
        return this.paymentService.create(orderItemDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.paymentService.delete(id);
    }
}
