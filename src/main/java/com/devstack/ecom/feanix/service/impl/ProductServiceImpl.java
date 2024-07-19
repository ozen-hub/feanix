package com.devstack.ecom.feanix.service.impl;

import com.devstack.ecom.feanix.dto.request.RequestProductDto;
import com.devstack.ecom.feanix.entity.Product;
import com.devstack.ecom.feanix.repository.ProductRepository;
import com.devstack.ecom.feanix.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public void create(RequestProductDto requestProductDto) {
        repository.save(toProduct(requestProductDto));
    }

    private Product toProduct(RequestProductDto dto){
        if (dto==null)return null;

        return Product.builder()
                .productId(UUID.randomUUID().toString())
                .description(dto.getDescription())
                .FileResource(null)
                .orderDetails(null)
                .qtyOnHand(dto.getQtyOnHand())
                .unitPrice(dto.getUnitPrice())
                .build();
    }
}
