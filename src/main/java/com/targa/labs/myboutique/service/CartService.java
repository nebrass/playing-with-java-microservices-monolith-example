package com.targa.labs.myboutique.service;

import com.targa.labs.myboutique.domain.Cart;
import com.targa.labs.myboutique.domain.Customer;
import com.targa.labs.myboutique.domain.Order;
import com.targa.labs.myboutique.domain.enumeration.CartStatus;
import com.targa.labs.myboutique.repository.CartRepository;
import com.targa.labs.myboutique.repository.CustomerRepository;
import com.targa.labs.myboutique.web.dto.CartDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CartService {

    private final Logger log = LoggerFactory.getLogger(CartService.class);

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final OrderService orderService;

    public CartService(CartRepository cartRepository, CustomerRepository customerRepository, OrderService orderService) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.orderService = orderService;
    }

    public static CartDto mapToDto(Cart cart) {
        if (cart != null) {
            return new CartDto(
                    cart.getId(),
                    cart.getOrder().getId(),
                    cart.getCustomer().getId(),
                    cart.getStatus().name()
            );
        }
        return null;
    }

    public List<CartDto> findAll() {
        log.debug("Request to get all Carts");
        return this.cartRepository.findAll()
                .stream()
                .map(CartService::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CartDto> findAllActiveCarts() {
        return this.cartRepository.findByStatus(CartStatus.NEW)
                .stream()
                .map(CartService::mapToDto)
                .collect(Collectors.toList());
    }

    public CartDto create(Long customerId) {
        if (this.getActiveCart(customerId) == null) {
            Customer customer = this.customerRepository.findById(customerId)
                    .orElseThrow(() -> new IllegalStateException("The Customer does not exist!"));

            Cart cart = new Cart(
                    null,
                    customer,
                    CartStatus.NEW
            );
            Order order = this.orderService.create(cart);
            cart.setOrder(order);

            return mapToDto(this.cartRepository.save(cart));
        } else {
            throw new IllegalStateException("There is already an active cart");
        }
    }

    @Transactional(readOnly = true)
    public CartDto findById(Long id) {
        log.debug("Request to get Cart : {}", id);
        return this.cartRepository.findById(id).map(CartService::mapToDto).orElse(null);
    }

    public void delete(Long id) {
        log.debug("Request to delete Cart : {}", id);
        Cart cart = this.cartRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find cart with id " + id));

        cart.setStatus(CartStatus.CANCELED);

        this.cartRepository.save(cart);
    }

    public CartDto getActiveCart(Long customerId) {
        List<Cart> carts = this.cartRepository
                .findByStatusAndCustomerId(CartStatus.NEW, customerId);
        if (carts != null) {

            if (carts.size() == 1) {
                return mapToDto(carts.get(0));
            }
            if (carts.size() > 1) {
                throw new IllegalStateException("Many active carts detected !!!");
            }
        }

        return null;
    }
}
