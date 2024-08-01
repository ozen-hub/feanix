package com.devstack.ecom.feanix.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestApplicationUserLoginDto {
    private String username;
    private String password;
}
