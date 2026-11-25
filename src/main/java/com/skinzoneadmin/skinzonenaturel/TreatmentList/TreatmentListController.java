package com.skinzoneadmin.skinzonenaturel.TreatmentList;

import com.skinzoneadmin.skinzonenaturel.Dtos.TreatmentCategoryDto;
import com.skinzoneadmin.skinzonenaturel.Dtos.TreatmentDto;
import com.skinzoneadmin.skinzonenaturel.Dtos.TreatmentUndetailedDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treatment")
public class TreatmentListController {
    @Autowired
    private TreatmentListService treatmentListService;
    @GetMapping("/categories")
    public List<TreatmentCategoryDto> getCategories(){
        return treatmentListService.getCategories();
    }
    @GetMapping("treatments")
    public List<TreatmentUndetailedDto> getTreatments(){
        return treatmentListService.getTreatmentList();
    }
    @GetMapping("/treatment/{id}")
    public TreatmentDto getTreatment(@PathVariable Integer id){
        return treatmentListService.getDetailedTreatment(id);
    }
    @PostMapping("/add/category")
    public Boolean addCategory(@RequestBody String treatmentCategoryName){
        return treatmentListService.addTreatmentCategory(treatmentCategoryName);
    }
    @PostMapping("/add/treatment")
    public TreatmentDto addTreatment(@RequestBody TreatmentDto treatmentDto){
        return treatmentListService.addTreatment(treatmentDto);
    }

    @PostMapping("/treatment/delete/{id}")
    public Boolean deleteTreatment(@PathVariable Integer id){
        return treatmentListService.deleteTreatmentById(id);
    }
}
