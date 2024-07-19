package com.devstack.ecom.feanix.service;

import com.devstack.ecom.feanix.dto.request.RequestProductDto;
import com.devstack.ecom.feanix.dto.response.ResponseProductDto;

public interface ProductService {
    public void create(RequestProductDto requestProductDto);
    public ResponseProductDto findById(String productId);
    public void update(RequestProductDto requestProductDto, String productId);
}
