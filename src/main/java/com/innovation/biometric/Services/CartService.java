package com.innovation.biometric.Services;

import com.innovation.biometric.Configuration.JwtRequestFilter;
import com.innovation.biometric.Model.Cart;
import com.innovation.biometric.Model.Product;
import com.innovation.biometric.Model.User;
import com.innovation.biometric.Reposiory.CartRepository;
import com.innovation.biometric.Reposiory.ProductRepo;
import com.innovation.biometric.Reposiory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {


    @Autowired
    private ProductRepo productRepo;

//    @Autowired
//    private CartRepository cartRepository;

    @Autowired
    private UserRepo userRepo;

//public Cart addToCart(Integer productId){
//    Product product = productRepo.findById(productId).get();
//    String username = JwtRequestFilter.CURRENT_USER;
//
//    User user = null;
//    if (username !=null) {
//        user = userRepo.findById(Long.valueOf(username)).get();
//    }
//    user = userRepo.findById(Long.valueOf(username)).get();
//
//    if (product != null && user!=null){
//        Cart cart = new Cart(user, product);
//        cartRepository.save(cart);
//    }
//    return null;
//}

}
