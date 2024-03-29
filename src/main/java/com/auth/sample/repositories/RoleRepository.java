package com.auth.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.sample.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);    
}
