package com.innovation.biometric.Model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String productName;

    private String productType;
    private Integer productPrice;

    private Integer productDiscount;


    public Product() {
    }

    public Product(Integer id, String productName, Integer productPrice, String productType, Integer productDiscount) {
        Id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productDiscount = productDiscount;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductDiscount() {
        return productDiscount;
    }

    public String getProductType() {return productType; }

    public void setProductType(String productType) {this.productType = productType; }
    public void setProductDiscount(Integer productDiscount) {
        this.productDiscount = productDiscount;
    }






}
