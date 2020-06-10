package com.advancedjava.springwebmvc.repository;

import com.advancedjava.springwebmvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.description like :description")
    List<Product> findProductByDescriptionContaining(@Param("description") String description);

    List<Product> findProductByUnitPriceBetween(Double minPrice, Double maxPrice);

    List<Product> findProductByDescription(String description);

}
