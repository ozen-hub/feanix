package com.devstack.ecom.feanix.api;

import com.devstack.ecom.feanix.dto.paginate.ResponseProductPaginateDto;
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

    @PutMapping("/{productId}")
    public String update(@RequestBody RequestProductDto dto,@PathVariable String productId) { // put -> body
        productService.update(dto,productId);
        return "Updated";
    }

    @DeleteMapping("/{productId}")
    public String delete(@PathVariable String productId) { // delete-> path variable, request params
        productService.delete(productId);
        return "Deleted";
    }

    @GetMapping("/search")
    public ResponseProductPaginateDto search(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) { // get-> path variable, request params
        return productService.search(searchText, page, size);
    }

}
