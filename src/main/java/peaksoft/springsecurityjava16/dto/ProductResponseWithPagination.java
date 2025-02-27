package peaksoft.springsecurityjava16.dto;

import peaksoft.springsecurityjava16.entities.Products;

import java.util.List;

public class ProductResponseWithPagination {
    private List<Products> products;
    private int page;
    private int pageSize;
    private int totalPages;
    private int totalCount;
}
