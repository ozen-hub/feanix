package com.devstack.ecom.feanix.service;

import com.devstack.ecom.feanix.dto.request.RequestUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ApplicationUserService extends UserDetailsService {
    public void create(RequestUserDto dto);
    public void initializeAdmin();
}
