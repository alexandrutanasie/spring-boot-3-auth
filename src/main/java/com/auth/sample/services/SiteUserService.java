package com.auth.sample.services;

import com.auth.sample.entities.SiteUser;

public interface SiteUserService {
    SiteUser findByEmail(String email);

    void saveUser(SiteUser user, String role);
}
