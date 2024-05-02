package com.springsecurity.oauth2.mapper;

import com.springsecurity.oauth2.dto.UserRegistrationDto;
import com.springsecurity.oauth2.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInfoMapper {

    private final PasswordEncoder passwordEncoder;
    public UserInfoEntity convertToEntity(UserRegistrationDto userRegistrationDto) {
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setUsername(userRegistrationDto.usuario());
        userInfoEntity.setEmailId(userRegistrationDto.correo());
        userInfoEntity.setMobileNumber(userRegistrationDto.telefono());
        userInfoEntity.setRoles(userRegistrationDto.rol());
        userInfoEntity.setPassword(passwordEncoder.encode(userRegistrationDto.contraseña()));
        return userInfoEntity;
    }
}

