package com.skinzoneadmin.skinzonenaturel.StockList;

import com.skinzoneadmin.skinzonenaturel.Entities.Product;
import org.hibernate.query.criteria.JpaFetchParent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Product,Integer> {

        List<Product> findAllProductByService_ServiceID(Integer integer);
}
