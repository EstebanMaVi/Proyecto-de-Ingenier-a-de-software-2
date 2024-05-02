package com.springsecurity.oauth2.config.userConfig;

import com.springsecurity.oauth2.entity.UserInfoEntity;
import com.springsecurity.oauth2.repo.UserInfoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class InitialUserInfo implements CommandLineRunner {
    private final UserInfoRepo userInfoRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        UserInfoEntity admin = new UserInfoEntity();
        admin.setUsername("Admin");
        admin.setPassword(passwordEncoder.encode("adm123"));
        admin.setRoles("ROLE_ADMIN");
        admin.setEmailId("admin@gmail.com");

        UserInfoEntity user = new UserInfoEntity();
        user.setUsername("Usuario");
        user.setPassword(passwordEncoder.encode("usr123"));
        user.setRoles("ROLE_USER");
        user.setEmailId("usuario@gmail.com");

        userInfoRepo.saveAll(List.of(admin,user));
    }
}