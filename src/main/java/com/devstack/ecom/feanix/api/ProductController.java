package com.devstack.ecom.feanix.api;

import com.devstack.ecom.feanix.dto.request.RequestProductDto;
import com.devstack.ecom.feanix.dto.response.ResponseProductDto;
import com.devstack.ecom.feanix.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public String save(@RequestBody RequestProductDto dto) { // post -> body
        productService.create(dto);
        return "Saved";
    }

    @GetMapping("/{productId}")
    public ResponseProductDto findById(@PathVariable String productId) { // get-> path variable, request params
        return productService.findById(productId);
    }
}
