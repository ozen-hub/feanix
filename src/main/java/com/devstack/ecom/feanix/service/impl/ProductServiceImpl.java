package com.devstack.ecom.feanix.service.impl;

import com.devstack.ecom.feanix.dto.request.RequestProductDto;
import com.devstack.ecom.feanix.dto.response.ResponseProductDto;
import com.devstack.ecom.feanix.entity.Product;
import com.devstack.ecom.feanix.repository.ProductRepository;
import com.devstack.ecom.feanix.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
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

    @Override
    public ResponseProductDto findById(String productId) {
        Optional<Product> selectedProduct = repository.findById(productId);
        if (selectedProduct.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        return toResponseProductDto(selectedProduct.get());
    }

    @Override
    public void update(RequestProductDto requestProductDto, String productId) {
        Optional<Product> selectedProduct = repository.findById(productId);
        if (selectedProduct.isEmpty()){
           throw new RuntimeException("Product not found");
        }
        Product product = selectedProduct.get();
        product.setDescription(requestProductDto.getDescription());
        product.setUnitPrice(requestProductDto.getUnitPrice());
        product.setQtyOnHand(requestProductDto.getQtyOnHand());
        repository.save(product);
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
    private ResponseProductDto toResponseProductDto(Product p){
        if (p==null)return null;

        return ResponseProductDto.builder()
                .productId(p.getProductId())
                .description(p.getDescription())
                .resourceUrl("")
                .qtyOnHand(p.getQtyOnHand())
                .unitPrice(p.getUnitPrice())
                .build();
    }
}
