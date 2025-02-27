package peaksoft.springsecurityjava16.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peaksoft.springsecurityjava16.dto.ProductRequest;
import peaksoft.springsecurityjava16.dto.ProductResponse;
import peaksoft.springsecurityjava16.dto.SimpleResponse;
import peaksoft.springsecurityjava16.entities.Products;
import peaksoft.springsecurityjava16.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public SimpleResponse save(ProductRequest productRequest) {
        Products products = new Products();
        products.setName(productRequest.getName());
        products.setPrice(productRequest.getPrice());
        products.setDescription(productRequest.getDescription());
        products.setTitle(productRequest.getTitle());
        products.setProductionDate(productRequest.getProductionDate());
        products.setExpiredDate(productRequest.getExpiredDate());
        products.setCount(productRequest.getCount());
        productRepository.save(products);
        log.info("save product success");
        return new SimpleResponse("Product saved successfully");
    }

    public Page<ProductResponse> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Products> products =  productRepository.findAll(pageable);
        System.out.println(products.getContent());
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Products product : products.getContent()) {
            ProductResponse productResponse = getProductResponse(product, products);
            productResponses.add(productResponse);
        }
        return new PageImpl<>(productResponses, pageable, products.getTotalElements());
    }

    private static ProductResponse getProductResponse(Products product, Page<Products> products) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        productResponse.setDescription(product.getDescription());
        productResponse.setProductionDate(product.getProductionDate());
        productResponse.setExpiredDate(product.getExpiredDate());
        if (products.getContent().size() != 0){
            productResponse.setInStock(true);
        }
        return productResponse;
    }
}
