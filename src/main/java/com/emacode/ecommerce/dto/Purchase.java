package com.emacode.ecommerce.dto;

import com.emacode.ecommerce.entity.Address;
import com.emacode.ecommerce.entity.Customer;
import com.emacode.ecommerce.entity.Order;
import com.emacode.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
