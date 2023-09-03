package com.online.shopping.orderservice.service;

import com.online.shopping.orderservice.dto.OrderLineItemsDto;
import com.online.shopping.orderservice.dto.OrderRequest;
import com.online.shopping.orderservice.model.Order;
import com.online.shopping.orderservice.model.OrderLineItems;
import com.online.shopping.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
/*
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

 */

    public void placeOrder(OrderRequest orderRequest){
    Order order=new Order();
    order.setOrderNumber(UUID.randomUUID().toString());

    List<OrderLineItems> orderLineItems= orderRequest.getOrderLineItemsDtoList()
            .stream()
            .map(this::mapToDto)
            .toList();

    order.setOrderLineItemsList(orderLineItems);
    orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());

        return orderLineItems;

    }
}
