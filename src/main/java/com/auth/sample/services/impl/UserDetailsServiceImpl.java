package com.auth.sample.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.auth.sample.entities.CustomUserDetails;
import com.auth.sample.entities.SiteUser;
import com.auth.sample.repositories.SiteUserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SiteUserRepository siteUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        SiteUser user = siteUserRepository.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("could not found user..!!");
        }
   
        return new CustomUserDetails(user);
    }
}
