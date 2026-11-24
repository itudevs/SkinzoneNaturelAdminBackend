package com.skinzoneadmin.skinzonenaturel.StockList;

import com.skinzoneadmin.skinzonenaturel.Dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockListController {
    @Autowired
    private StockService stockService;
    @PostMapping("/add")
    public ProductDto addProduct(@RequestBody ProductDto productDto){
        return  stockService.addProduct(productDto);
    }
    @GetMapping("/remove/{id}")
    public Boolean removeProduct(@PathVariable Integer id){
        return stockService.deleteProductById(id);
    }
    @PostMapping("/update")
    public ProductDto updateProduct(@RequestBody ProductDto productDto){
        return stockService.updateProductById(productDto);
    }
}
