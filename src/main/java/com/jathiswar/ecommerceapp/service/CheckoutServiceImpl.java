package com.jathiswar.ecommerceapp.service;

import com.jathiswar.ecommerceapp.dao.CustomerRepository;
import com.jathiswar.ecommerceapp.dto.Purchase;
import com.jathiswar.ecommerceapp.dto.PurchaseResponse;
import com.jathiswar.ecommerceapp.entity.Customer;
import com.jathiswar.ecommerceapp.entity.Order;
import com.jathiswar.ecommerceapp.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;


    public CheckoutServiceImpl(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Order order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);


        Set<OrderItem> orderItems = purchase.getOrderItems();

        orderItems.forEach(item-> order.add(item));

        order.setBillingAddress(purchase.getBillingAddress());

        order.setShippingAddress(purchase.getShippingAddress());

        Customer customer = purchase.getCustomer();
        customer.add(order);

        customerRepository.save(customer);


        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}
