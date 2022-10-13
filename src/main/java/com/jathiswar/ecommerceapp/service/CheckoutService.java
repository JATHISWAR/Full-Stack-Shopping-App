package com.jathiswar.ecommerceapp.service;

import com.jathiswar.ecommerceapp.dto.Purchase;
import com.jathiswar.ecommerceapp.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
