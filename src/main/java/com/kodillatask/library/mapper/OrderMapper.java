package com.kodillatask.library.mapper;

import com.kodillatask.library.domian.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderMapper {

    Users users=new Users();

    public Order mapToOrder (final OrderDto order){
        return new Order(order.getId(), order.getStatus(),new Users (order.getUserId()),new Copy(order.getCopyId()));
    }

    public OrderDto maptoOrderDto (final Order order){
        return new OrderDto(order.getId(),order.getStatus(),order.getUsers().getId(),order.getCopy().getId());//,order.getCopyList());
    }

    public List<OrderDto> mapToOrderList(final List<Order> orderList){
        return orderList.stream().map(this::maptoOrderDto).collect(Collectors.toList());
    }
}
