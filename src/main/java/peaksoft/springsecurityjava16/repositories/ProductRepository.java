package peaksoft.springsecurityjava16.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.springsecurityjava16.entities.Products;


public interface ProductRepository extends JpaRepository<Products, Long> {
//    Page<Products> getProducts(Pageable pageable);
}

