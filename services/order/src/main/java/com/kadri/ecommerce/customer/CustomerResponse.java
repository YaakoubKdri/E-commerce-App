package com.kadri.ecommerce.customer;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
