package com.online.shopping.orderservice.dto;

import com.online.shopping.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

   private List<OrderLineItemsDto> orderLineItemsDtoList;
}
