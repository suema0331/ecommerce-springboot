package com.emacode.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    // note: Lombok @Data will generate constructor for final fields
    // or @NonNull
    // private String orderTrackingNumber;
    private final String orderTrackingNumber;
}
