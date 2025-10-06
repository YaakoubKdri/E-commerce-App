package com.kadri.ecommerce.kafka;

import com.kadri.ecommerce.customer.CustomerResponse;
import com.kadri.ecommerce.order.PaymentMethod;
import com.kadri.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
