package com.kadri.ecommerce.order;

import com.kadri.ecommerce.customer.CustomerClient;
import com.kadri.ecommerce.exception.BusinessException;
import com.kadri.ecommerce.orderline.OrderLineRequest;
import com.kadri.ecommerce.orderline.OrderLineService;
import com.kadri.ecommerce.product.ProductClient;
import com.kadri.ecommerce.product.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderMapper mapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(OrderRequest request) {
        //check the customer
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(()->new BusinessException("Cannot create order:: No Customer exist with the provided ID:: " + request.customerId()));
        //purchase the product --> product-ms
        productClient.purchaseProducts(request.products());
        //persist order
        var order = repository.save(mapper.toOrder(request));
        //persist order lines
        for(PurchaseRequest purchaseRequest : request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }
        //todo start payment process
        //send the order confirmation --> notification-ms
        return null;
    }
}
