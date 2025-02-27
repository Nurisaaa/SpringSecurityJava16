package peaksoft.springsecurityjava16.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import peaksoft.springsecurityjava16.dto.ProductRequest;
import peaksoft.springsecurityjava16.dto.ProductResponse;
import peaksoft.springsecurityjava16.dto.ProductResponseWithPagination;
import peaksoft.springsecurityjava16.dto.SimpleResponse;
import peaksoft.springsecurityjava16.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {
    private final ProductService productService;

    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public SimpleResponse saveProduct(@RequestBody ProductRequest productRequest){
        return productService.save(productRequest);
    }

    @GetMapping
    public Page<ProductResponse>  getAllProducts(@RequestParam int page, @RequestParam int size){
        return productService.getAllProducts(page, size);
    }
}
