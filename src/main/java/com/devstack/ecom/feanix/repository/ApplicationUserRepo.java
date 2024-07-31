package com.devstack.ecom.feanix.repository;

import com.devstack.ecom.feanix.entity.ApplicationUser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationUserRepo extends JpaRepository<ApplicationUser,String> {

     Optional<ApplicationUser> findByUsername(String username);
}
