package com.devstack.ecom.feanix.service;

import com.devstack.ecom.feanix.dto.paginate.ResponseProductPaginateDto;
import com.devstack.ecom.feanix.dto.request.RequestProductDto;
import com.devstack.ecom.feanix.dto.response.ResponseProductDto;

public interface ProductService {
    public void create(RequestProductDto requestProductDto);
    public ResponseProductDto findById(String productId);
    public void update(RequestProductDto requestProductDto, String productId);
    public void delete(String productId);
    public ResponseProductPaginateDto search(String searchText,int page, int size);
}
