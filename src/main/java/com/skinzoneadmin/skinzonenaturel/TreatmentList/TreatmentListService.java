package com.skinzoneadmin.skinzonenaturel.TreatmentList;

import com.skinzoneadmin.skinzonenaturel.Dtos.TreatmentCategoryDto;
import com.skinzoneadmin.skinzonenaturel.Dtos.TreatmentDto;
import com.skinzoneadmin.skinzonenaturel.Dtos.TreatmentUndetailedDto;
import com.skinzoneadmin.skinzonenaturel.Entities.Product;
import com.skinzoneadmin.skinzonenaturel.Entities.Treatment;
import com.skinzoneadmin.skinzonenaturel.Entities.Treatment_Category;
import com.skinzoneadmin.skinzonenaturel.Repositories.ServiceRepository;
import main.java.structures.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TreatmentListService {
    @Autowired
    private TreatmentCategoryRepository  treatmentCategoryRepository;
    @Autowired
    private TreatmentRepository  treatmentRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    public List<TreatmentCategoryDto> getCategories(){
        List<TreatmentCategoryDto> treatmentCategoryDtos = new ArrayList<>();
        List<Treatment_Category> optionalTreatmentCategory=treatmentCategoryRepository.findAll();
        if(optionalTreatmentCategory.isEmpty()){
            return treatmentCategoryDtos;
        }else{
            for(Treatment_Category treatmentCategory:optionalTreatmentCategory){
                int numberOfTreatmentsInCategory=treatmentRepository.findAllTreatmentByCategory(treatmentCategory).size();
                treatmentCategoryDtos.add(new TreatmentCategoryDto(treatmentCategory.getCategoryName(),numberOfTreatmentsInCategory));
            }
            return treatmentCategoryDtos;
        }
    }
    public List<TreatmentUndetailedDto> getTreatmentList(){
        List<TreatmentUndetailedDto> treatmentDtos = new ArrayList<>();
        List<Treatment> optionalTreatment=treatmentRepository.findAll();
        if(optionalTreatment.isEmpty()){
            return treatmentDtos;
        }else{
            for(Treatment treatment:optionalTreatment){
                com.skinzoneadmin.skinzonenaturel.Entities.Service service=treatment.getService();
                treatmentDtos.add(new TreatmentUndetailedDto(treatment.getId(), service.getName(), service.getRetailPrice()));
            }
            return treatmentDtos;
        }
    }
    public Boolean addTreatmentCategory(String categoryName){
        try{
            String newCategory=categoryName.toUpperCase();
            Treatment_Category treatmentCategory=new Treatment_Category();
            treatmentCategory.setCategoryName(newCategory);
            treatmentCategoryRepository.save(treatmentCategory);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    public TreatmentDto getDetailedTreatment(Integer treatmentId){
        Optional<Treatment> optional=treatmentRepository.findById(treatmentId);
        if(optional.isPresent()){
            Treatment treatment=optional.get();
            com.skinzoneadmin.skinzonenaturel.Entities.Service service=treatment.getService();
            return new TreatmentDto(service.getName(),treatment.getCategory().getCategoryName(),service.getRetailPrice(),
                    service.getDiscount(),treatment.getNumberOfPeopleTreated());
        }else{
            return null;
        }
    }
    public TreatmentDto addTreatment(TreatmentDto treatmentDto){
        Treatment treatment=new Treatment();
        com.skinzoneadmin.skinzonenaturel.Entities.Service service=new com.skinzoneadmin.skinzonenaturel.Entities.Service();
        service.setName(treatmentDto.name());
        service.setActive(true);
        service.setRetailPrice(treatmentDto.retailPrice());
        service.setDiscount(treatmentDto.discount());
        service.setType(ServiceType.TREATMENT);
        serviceRepository.save(service);
        treatment.setService(service);
        treatment.setNumberOfPeopleTreated(0);
        Optional<Treatment_Category> treatmentCategory=treatmentCategoryRepository.findCategoryByCategoryName(treatmentDto.category());
        if(treatmentCategory.isPresent()){
            treatment.setCategory(treatmentCategory.get());
            treatmentRepository.save(treatment);
            return treatmentDto;
        }else{
            return null;
        }
    }
    public Boolean deleteTreatmentById(Integer productId){
        Optional<Treatment> treatment=treatmentRepository.findById(productId);
        if(treatment.isPresent()){
            com.skinzoneadmin.skinzonenaturel.Entities.Service service=treatment.get().getService();
            service.setActive(false);
            serviceRepository.save(service);
            return true;
        }else{
            return false;
        }
    }
}
