package com.devstack.ecom.feanix.service.impl;

import com.devstack.ecom.feanix.entity.ApplicationUser;
import com.devstack.ecom.feanix.entity.UserRole;
import com.devstack.ecom.feanix.exception.EntryNotFoundException;
import com.devstack.ecom.feanix.repository.ApplicationUserRepo;
import com.devstack.ecom.feanix.security.SupportSpringApplicationUser;
import com.devstack.ecom.feanix.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.devstack.ecom.feanix.security.ApplicationUserRole.ADMIN;
import static com.devstack.ecom.feanix.security.ApplicationUserRole.USER;

@Service
@RequiredArgsConstructor
public class ApplicationUserServiceImpl implements ApplicationUserService {
    private final ApplicationUserRepo userRepo;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> selectedUserData = userRepo.findByUsername(username);
        if (selectedUserData.isEmpty()){
            throw new EntryNotFoundException(String.format("username %s not found",username));
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();

        for (UserRole u:selectedUserData.get().getRoles()){
            if(u.getRoleName().equals("ADMIN")){
                grantedAuthorities.addAll(ADMIN.grantedAuthorities());
            }
            if(u.getRoleName().equals("USER")){
                grantedAuthorities.addAll(USER.grantedAuthorities());
            }
        }
        return new SupportSpringApplicationUser(
                selectedUserData.get().getUsername(),
                selectedUserData.get().getPassword(),
                selectedUserData.get().isAccountNonExpired(),
                selectedUserData.get().isAccountNonLocked(),
                selectedUserData.get().isCredentialsNonExpired(),
                selectedUserData.get().isEnabled(),
                grantedAuthorities
        );
    }
}
