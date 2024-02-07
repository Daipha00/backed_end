package com.innovation.biometric.Services;


import com.innovation.biometric.Model.Product;
import com.innovation.biometric.Reposiory.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAll() {return productRepo.findAll();}

    public Product getProductById(int Id){return productRepo.findById(Id).orElse(null);}

    public Product addProduct(Product product){ productRepo.save(product);
        return product;
    }

    public void updateProduct(Integer id, Product product){
        Product existingProduct = productRepo.findById(id).orElse(null);
        if (existingProduct !=null){
            existingProduct.setProductName(product.getProductName());
            existingProduct.setProductDiscount(product.getProductDiscount());
            existingProduct.setProductPrice(product.getProductPrice());
            productRepo.save(existingProduct);
        }
    }

    public void delete(Integer Id){productRepo.deleteById(Id);}

}




