package com.devstack.ecom.feanix.api;

import com.devstack.ecom.feanix.dto.paginate.ResponseProductPaginateDto;
import com.devstack.ecom.feanix.dto.request.RequestProductDto;
import com.devstack.ecom.feanix.dto.response.ResponseProductDto;
import com.devstack.ecom.feanix.service.ProductService;
import com.devstack.ecom.feanix.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<StandardResponseDto> save(@RequestBody RequestProductDto dto) { // post -> body
        productService.create(dto);

        return new ResponseEntity<>(
                new StandardResponseDto("product has been saved..",201,null),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{productId}")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public  ResponseEntity<StandardResponseDto> findById(@PathVariable String productId) { // get-> path variable, request params
        return new ResponseEntity<>(
                new StandardResponseDto("selected product..",200,productService.findById(productId)),
                HttpStatus.OK
        );
    }

    @PutMapping("/{productId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public  ResponseEntity<StandardResponseDto> update(@RequestBody RequestProductDto dto,@PathVariable String productId) { // put -> body
        productService.update(dto,productId);
        return new ResponseEntity<>(
                new StandardResponseDto("product has been modified..",201,null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{productId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public  ResponseEntity<StandardResponseDto> delete(@PathVariable String productId) { // delete-> path variable, request params
        productService.delete(productId);
        return new ResponseEntity<>(
                new StandardResponseDto("product has been deleted..",204,null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping("/visitor/search")
    public  ResponseEntity<StandardResponseDto> search(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ) { // get-> path variable, request params

        return new ResponseEntity<>(
                new StandardResponseDto("product list",200,productService.search(searchText, page, size)),
                HttpStatus.OK
        );
    }

}
