package com.skinzoneadmin.skinzonenaturel.StockList;

import com.skinzoneadmin.skinzonenaturel.Dtos.ProductDto;
import com.skinzoneadmin.skinzonenaturel.Entities.Product;
import com.skinzoneadmin.skinzonenaturel.Entities.Product_Category;
import com.skinzoneadmin.skinzonenaturel.Repositories.ServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {
    private static final Logger log = LoggerFactory.getLogger(StockService.class);
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private  ProductCategoryRepository productCategoryRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    public List<ProductDto> getProducts(){
      List<ProductDto> productDtoList=new ArrayList<>();
      List< Product> productList=stockRepository.findAll();
      for(Product product:productList){
          com.skinzoneadmin.skinzonenaturel.Entities.Service service=new com.skinzoneadmin.skinzonenaturel.Entities.Service();
          productDtoList.add(new ProductDto(product.getProductID(),service.getName(),product.getProductCategory().getProductCategoryName(),
                  product.getQuantity(),service.getRetailPrice(),product.getClinicalPrice(),product.getDateReceived()));
      }
      return productDtoList;
    }

    public ProductDto updateProductById(ProductDto productDto){
        Optional<Product> product=stockRepository.findById(productDto.productId());
        if(product.isPresent()){
            try{
              Product foundProduct=product.get();
              com.skinzoneadmin.skinzonenaturel.Entities.Service service=new com.skinzoneadmin.skinzonenaturel.Entities.Service();
              service.setName(productDto.productName());
              service.setRetailPrice(productDto.retailPrice());
              serviceRepository.save(service);
              foundProduct.setService(service);
              foundProduct.setClinicalPrice(productDto.clinicalPrice());
              Optional<Product_Category> productCategory=productCategoryRepository.findByProductCategoryName(productDto.productCategory());
              if(productCategory.isPresent()){
                  foundProduct.setProductCategory(productCategory.get());
                  foundProduct.setQuantity(productDto.productQuantity());
                  foundProduct.setDateReceived(productDto.dateReceived());
              }else{
                  System.err.println("Could not find product category");
                  return null;
              }
              stockRepository.save(foundProduct);
              return productDto;
            }catch(Exception e){
                //Development
                e.printStackTrace();
                return null;
            }
        }else{
            return null;
        }

    }
    public Boolean deleteProductById(Integer productId){
      Optional<Product> product=stockRepository.findById(productId);
      if(product.isPresent()){
          com.skinzoneadmin.skinzonenaturel.Entities.Service service=product.get().getService();
          service.setActive(false);
          serviceRepository.save(service);
          return true;
      }else{
          return false;
      }
    }
    public ProductDto addProduct(ProductDto productDto){

        Optional<com.skinzoneadmin.skinzonenaturel.Entities.Service> service=serviceRepository.findServiceByName(productDto.productName());
        if(service.isEmpty()){
            com.skinzoneadmin.skinzonenaturel.Entities.Service newService=new com.skinzoneadmin.skinzonenaturel.Entities.Service();
            newService.setName(productDto.productName());
            newService.setRetailPrice(productDto.retailPrice());
            serviceRepository.save(newService);
            Product newProduct=new Product();
            newProduct.setService(newService);
            newProduct.setQuantity(productDto.productQuantity());
            newProduct.setDateReceived(productDto.dateReceived());
            newProduct.setClinicalPrice(productDto.clinicalPrice());
            stockRepository.save(newProduct);
            return productDto;
        }
        return null;
    }
}
