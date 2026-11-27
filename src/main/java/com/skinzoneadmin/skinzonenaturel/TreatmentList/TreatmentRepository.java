package com.skinzoneadmin.skinzonenaturel.TreatmentList;

import com.skinzoneadmin.skinzonenaturel.Dtos.TreatmentCategoryDto;
import com.skinzoneadmin.skinzonenaturel.Entities.Treatment;
import com.skinzoneadmin.skinzonenaturel.Entities.Treatment_Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
     List<Treatment> findAllTreatmentByCategory(Treatment_Category treatmentCategory);

    List<Treatment> findAllTreatmentByService_ServiceID(int serviceServiceID);
}
