package com.devstack.ecom.feanix.service.impl;

import com.devstack.ecom.feanix.dto.paginate.ResponseProductPaginateDto;
import com.devstack.ecom.feanix.dto.request.RequestProductDto;
import com.devstack.ecom.feanix.dto.response.ResponseProductDto;
import com.devstack.ecom.feanix.entity.Product;
import com.devstack.ecom.feanix.exception.EntryNotFoundException;
import com.devstack.ecom.feanix.repository.ProductRepository;
import com.devstack.ecom.feanix.service.ProductService;
import com.devstack.ecom.feanix.util.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final IdGenerator idGenerator;

    @Override
    public void create(RequestProductDto requestProductDto) {
        repository.save(toProduct(requestProductDto));
    }

    @Override
    public ResponseProductDto findById(String productId) {
        Optional<Product> selectedProduct = repository.findById(productId);
        if (selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product not found");
        }
        return toResponseProductDto(selectedProduct.get());
    }

    @Override
    public void update(RequestProductDto requestProductDto, String productId) {
        Optional<Product> selectedProduct = repository.findById(productId);
        if (selectedProduct.isEmpty()){
            throw new EntryNotFoundException("Product not found");
        }
        Product product = selectedProduct.get();
        product.setDescription(requestProductDto.getDescription());
        product.setUnitPrice(requestProductDto.getUnitPrice());
        product.setQtyOnHand(requestProductDto.getQtyOnHand());
        repository.save(product);
    }

    @Override
    public void delete(String productId) {
        repository.deleteById(productId);
    }

    @Override
    public ResponseProductPaginateDto search(String searchText, int page, int size) {

        return ResponseProductPaginateDto.builder()
                .count(
                        repository.searchCount(searchText)
                )
                .dataList(
                        repository.searchAll(searchText, PageRequest.of(page,size)).
                                stream().map(this::toResponseProductDto).toList()
                )
                .build();
    }

    private Product toProduct(RequestProductDto dto){
        if (dto==null)return null;

        return Product.builder()
                .productId(idGenerator.generate())
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
