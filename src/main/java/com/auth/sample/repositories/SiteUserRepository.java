package com.auth.sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.sample.entities.SiteUser;


public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
    SiteUser findByEmail(String email);
}
