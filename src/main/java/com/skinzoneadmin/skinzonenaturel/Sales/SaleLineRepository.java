package com.skinzoneadmin.skinzonenaturel.Sales;

import com.skinzoneadmin.skinzonenaturel.Entities.Sale;
import com.skinzoneadmin.skinzonenaturel.Entities.Sale_Line;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleLineRepository extends JpaRepository<Sale_Line,Integer> {
    List<Sale_Line> findAllBySale(Sale sale);
}
