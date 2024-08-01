package com.devstack.ecom.feanix.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "application_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationUser {
    @Id
    @Column(name = "user_id", length = 80)
    private String userId;
    @Column(name = "username", length = 100, unique = true)
    private String username;
    @Column(name = "password", length = 750, nullable = false)
    private String password;
    @Column(name = "address", length = 750, nullable = false)
    private String address;

    @Column(name = "is_account_non_expired",columnDefinition = "TINYINT")
    private boolean isAccountNonExpired;
    @Column(name = "is_account_non_locked",columnDefinition = "TINYINT")
    private boolean isAccountNonLocked;
    @Column(name = "is_credentials_non_expired",columnDefinition = "TINYINT")
    private boolean isCredentialsNonExpired;
    @Column(name = "is_enabled",columnDefinition = "TINYINT")
    private boolean isEnabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<CustomerOrder> customerOrders = new HashSet<>();

    @ManyToMany
    @JoinTable(name="user_user_role",
    joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserRole> roles;

}
