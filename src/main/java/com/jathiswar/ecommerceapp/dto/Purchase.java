package com.jathiswar.ecommerceapp.dto;

import com.jathiswar.ecommerceapp.entity.Address;
import com.jathiswar.ecommerceapp.entity.Customer;
import com.jathiswar.ecommerceapp.entity.Order;
import com.jathiswar.ecommerceapp.entity.OrderItem;
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
