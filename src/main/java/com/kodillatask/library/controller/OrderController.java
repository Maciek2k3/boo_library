package com.kodillatask.library.controller;

import com.kodillatask.library.domian.Order;
import com.kodillatask.library.domian.OrderDto;
import com.kodillatask.library.mapper.OrderMapper;
import com.kodillatask.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/v1")
@CrossOrigin(origins = "*")
public class OrderController {
    private OrderMapper orderMapper;
    private OrderService orderService;

    @Autowired
    public OrderController(OrderMapper orderMapper, OrderService orderService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
    }


    @GetMapping("/getOrders")
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderService.findAllOrder();
        return orderMapper.mapToOrderList(orders);
    }

    @GetMapping("/getOrder")
    @ResponseBody
    public OrderDto getByIdOrder(@RequestParam long id) throws NotFoundEeption {
        return orderMapper.maptoOrderDto(orderService.findOrderById(id).orElseThrow(NotFoundEeption::new));
    }


    @DeleteMapping("/deleteOrder")
    public void deleteByIdOrder(@RequestParam long id) {
        orderService.deleteOrderById(id);
    }

    @PutMapping("/updateOrder")
    public OrderDto udpateOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        Order savedOrder = orderService.saveOrder(order);
        return orderMapper.maptoOrderDto(savedOrder);
    }

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody OrderDto orderDto) {
        Order order = orderMapper.mapToOrder(orderDto);
        orderService.saveOrder(order);
    }
}
