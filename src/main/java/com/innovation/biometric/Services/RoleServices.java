package com.innovation.biometric.Services;

import com.innovation.biometric.Model.Role;
import com.innovation.biometric.Reposiory.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServices {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }
}
