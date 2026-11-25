package com.skinzoneadmin.skinzonenaturel.StockList;

import com.skinzoneadmin.skinzonenaturel.Entities.Product_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<Product_Category,Integer> {

    Optional<Product_Category> findByProductCategoryName(String productCategoryName);
}
