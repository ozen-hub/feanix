package com.devstack.ecom.feanix;

import com.devstack.ecom.feanix.service.ApplicationUserRoleService;
import com.devstack.ecom.feanix.service.ApplicationUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FeanixApplication implements CommandLineRunner {

    private final ApplicationUserRoleService userRoleService;
    private final ApplicationUserService applicationUserService;

    public FeanixApplication(ApplicationUserRoleService userRoleService, ApplicationUserService applicationUserService) {
        this.userRoleService = userRoleService;
        this.applicationUserService = applicationUserService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeanixApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // save all roles if not exists
        userRoleService.initializeRoles();

        // save user (ADMIN)-> if not exists
        applicationUserService.initializeAdmin();
    }
}
