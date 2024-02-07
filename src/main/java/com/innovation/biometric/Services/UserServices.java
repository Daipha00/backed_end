package com.innovation.biometric.Services;

import com.innovation.biometric.Model.Role;
import com.innovation.biometric.Model.User;
import com.innovation.biometric.Reposiory.RoleRepo;
import com.innovation.biometric.Reposiory.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServices {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;


    @Autowired
    private PasswordEncoder passwordEncoder;

   public User createUser(User user){
       return userRepo.save(user);
   }

   @Transactional
    public void initUserRoles() {
       Role adminRole = new Role();
       adminRole.setRoleName("Admin");
       adminRole.setRoleDescription("Roles for admin");
       roleRepo.save(adminRole);

       Role userRole = new Role();
       userRole.setRoleName("User");
       userRole.setRoleDescription("Roles for user");
       roleRepo.save(userRole);

//       Role customerRole = new Role();
//       userRole.setRoleName("Customer");
//       userRole.setRoleDescription("customer Role");
//       roleRepo.save(userRole);

       User adminUser = new User();
       adminUser.setId(1L);
       adminUser.setUserName("haji");
       adminUser.setUserPassword(getEncodedPassword("admin123"));
       adminUser.setUserFirstName("Rahel");
       adminUser.setUserLastName("Ombeni");
       adminUser.setEmail("msagaladaines@gmail.com");
       adminUser.setAddress("Jumbi");
       adminUser.setPhoneNumber("0710287645");
       Set<Role> adminRoles = new HashSet<>();
       adminRoles.add(adminRole);
       adminUser.setRole(adminRoles);
       userRepo.save(adminUser);

//        User user = new User();
//        user.setUserName("Daipha");
//        user.setUserPassword(getEncodedPassword("user123"));
//        user.setUserFirstName("Dainess");
//        user.setUserLastName("Nyamwanji");
//        user.setEmail("sammymsagala@gmail.com");
//        user.setAddress("Tunguu");
//        user.setPhoneNumber("0676897645");
//        Set<Role> userRoles = new HashSet<>();
//        user.setRole(userRoles);
//        userRoles.add(userRole);
//        userRepo.save(user);

   }


       public User registerNewUser (User user){
           Role role = roleRepo.findById("User").get();
           Set<Role> userRoles = new HashSet<>();
           userRoles.add(role);
           user.setRole(userRoles);
           user.setUserPassword(getEncodedPassword(user.getUserPassword()));

           return userRepo.save(user);
       }

//    public Customer registerCustomer (Customer user){
//        Role role = roleRepo.findById("User").get();
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(role);
//        user.setRole(userRoles);
//        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
//
//        return customerRepo.save(user);
//    }


       public String getEncodedPassword (String password){
           return passwordEncoder.encode(password);

       }
   }

