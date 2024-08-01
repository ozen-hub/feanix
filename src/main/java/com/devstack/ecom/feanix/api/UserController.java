package com.devstack.ecom.feanix.api;

import com.devstack.ecom.feanix.dto.request.RequestUserDto;
import com.devstack.ecom.feanix.service.ApplicationUserService;
import com.devstack.ecom.feanix.util.StandardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final ApplicationUserService applicationUserService;

    @PostMapping("/signup")
    public ResponseEntity<StandardResponseDto> signup(
            @RequestBody RequestUserDto dto
    ) {
        applicationUserService.create(dto);
        return new ResponseEntity<>(
                new StandardResponseDto("User Created..", 201, dto.getUsername()),
                HttpStatus.CREATED
        );
    }
}
