package com.innovation.biometric.Controller;

import com.innovation.biometric.Model.Role;
import com.innovation.biometric.Services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
@Autowired
private RoleServices roleServices;

@PostMapping({"/createRole"})
    public Role createNewRole(@RequestBody Role role){
          return roleServices.createNewRole(role);
    }



}
