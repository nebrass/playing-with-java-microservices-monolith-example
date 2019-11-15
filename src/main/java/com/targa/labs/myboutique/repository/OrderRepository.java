package com.targa.labs.myboutique.repository;

import com.targa.labs.myboutique.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCartCustomer_Id(Long id);
}
