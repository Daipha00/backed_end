package com.innovation.biometric.Controller;


import com.innovation.biometric.Model.Product;
import com.innovation.biometric.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public List<Product>getAll(){
        return productService.getAll();}

    @GetMapping("/getProduct/{Id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }


//    @PostMapping("/addProduct")
//    public void addProduct(@RequestBody Product product){
//        productService.addProduct(product);
//    }

    @PostMapping("/addProduct")
    public void addProduct(@ModelAttribute Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/updateProduct/{id}")
    public void updateProduct(@PathVariable Integer id,@RequestBody Product product){
        productService.updateProduct(id,product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void delete(@PathVariable Integer id){productService.delete(id);}

}


