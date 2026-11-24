package com.skinzoneadmin.skinzonenaturel.StockList;

import com.skinzoneadmin.skinzonenaturel.Dtos.ProductDto;
import com.skinzoneadmin.skinzonenaturel.Entities.Product;
import com.skinzoneadmin.skinzonenaturel.Entities.Product_Category;
import com.skinzoneadmin.skinzonenaturel.Repositories.ServiceRepository;
import main.java.structures.ServiceType;
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
          com.skinzoneadmin.skinzonenaturel.Entities.Service service=product.getService();
          productDtoList.add(new ProductDto(product.getProductID(),service.getName(),product.getProductCategory().getProductCategoryName(),
                  product.getQuantity(),service.getRetailPrice(),product.getClinicalPrice(),product.getDateReceived()));
      }
      return productDtoList;
    }

    public ProductDto updateProductById(ProductDto productDto){
        Optional<Product> product=stockRepository.findById(productDto.id());
        if(product.isPresent()){
            try{
              Product foundProduct=product.get();
              com.skinzoneadmin.skinzonenaturel.Entities.Service service= foundProduct.getService();
              service.setName(productDto.name());
              service.setRetailPrice(productDto.retailPrice());
              serviceRepository.save(service);
              foundProduct.setService(service);
              foundProduct.setClinicalPrice(productDto.clinicalPrice());
              Optional<Product_Category> productCategory=productCategoryRepository.findByProductCategoryName(productDto.category());
              if(productCategory.isPresent()){
                  foundProduct.setProductCategory(productCategory.get());
                  foundProduct.setQuantity(productDto.amountAvailable());
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

        Optional<com.skinzoneadmin.skinzonenaturel.Entities.Service> service=serviceRepository.findServiceByName(productDto.name());
        if(service.isEmpty()){
            com.skinzoneadmin.skinzonenaturel.Entities.Service newService=new com.skinzoneadmin.skinzonenaturel.Entities.Service();
            System.out.println("Name"+productDto.name());
            newService.setName(productDto.name());
            newService.setRetailPrice(productDto.retailPrice());
            newService.setType(ServiceType.PRODUCT);
            newService.setDiscount(0.0F);
            newService.setActive(true);
            serviceRepository.save(newService);
            Product newProduct=new Product();
            newProduct.setService(newService);
            newProduct.setQuantity(productDto.amountAvailable());
            newProduct.setDateReceived(productDto.dateReceived());
            newProduct.setClinicalPrice(productDto.clinicalPrice());
            Optional<Product_Category> productCategory=productCategoryRepository.findByProductCategoryName(productDto.category());
            if(productCategory.isPresent()){
                newProduct.setProductCategory(productCategory.get());
                stockRepository.save(newProduct);
            }else{
                return null;
            }

            return productDto;
        }
        return null;
    }
    public Boolean addProductCategory(String productCategoryName){
        Optional<Product_Category> productCategory=productCategoryRepository.findByProductCategoryName(productCategoryName);
        if(productCategory.isEmpty()){
            Product_Category newProductCategory=new Product_Category();
            newProductCategory.setProductCategoryName(productCategoryName);
            productCategoryRepository.save(newProductCategory);
            return true;
        }else{
            return false;
        }
    }
    public List<String> getProductCategories(){
        List<String> productCategories=new ArrayList<>();
        List< Product_Category> productCategoryList=productCategoryRepository.findAll();
        for(Product_Category productCategory:productCategoryList){
            productCategories.add(productCategory.getProductCategoryName());
        }
        return productCategories;
    }
}
