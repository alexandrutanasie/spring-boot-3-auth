package com.auth.sample.services.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.sample.entities.SiteUser;
import com.auth.sample.entities.Role;
import com.auth.sample.repositories.SiteUserRepository;
import com.auth.sample.repositories.RoleRepository;
import com.auth.sample.services.SiteUserService;

@Service
public class SiteUserServiceImpl implements SiteUserService {

    @Autowired
    private SiteUserRepository siteUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository siteUserRoleRepository;

    @Override
    public SiteUser findByEmail(String email) {
       return siteUserRepository.findByEmail(email);
    }

    @Override
    public void saveUser(SiteUser user, String role) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role _role = siteUserRoleRepository.findByName(role);
        Set roles = new HashSet<>();
        roles.add(_role);
        
        user.setRoles(roles);
        siteUserRepository.save(user);
    }
    
}
