package com.kodillatask.library.service;

import com.kodillatask.library.domian.Order;
import com.kodillatask.library.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    public final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllOrder() {
        return orderRepository.findAll();

    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }


}
