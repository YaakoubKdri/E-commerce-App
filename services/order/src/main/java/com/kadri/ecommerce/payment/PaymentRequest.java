package com.kadri.ecommerce.payment;

import com.kadri.ecommerce.customer.CustomerResponse;
import com.kadri.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
