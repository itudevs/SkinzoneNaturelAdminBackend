package com.skinzoneadmin.skinzonenaturel.Sales;

import com.skinzoneadmin.skinzonenaturel.Entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findAllByClient_Id(Integer clientId);
}
