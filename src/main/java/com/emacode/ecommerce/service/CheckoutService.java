package com.emacode.ecommerce.service;

import com.emacode.ecommerce.dto.Purchase;
import com.emacode.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
