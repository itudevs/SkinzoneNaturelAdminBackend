package com.skinzoneadmin.skinzonenaturel.TreatmentList;

import com.skinzoneadmin.skinzonenaturel.Entities.Treatment_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreatmentCategoryRepository extends JpaRepository<Treatment_Category, Integer> {
  Optional<Treatment_Category> findCategoryByCategoryName(String treatmentCategoryName);
}
