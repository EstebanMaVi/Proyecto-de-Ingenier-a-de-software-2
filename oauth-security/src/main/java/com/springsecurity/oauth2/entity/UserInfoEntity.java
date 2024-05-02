package com.springsecurity.oauth2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER_INFO")
public class UserInfoEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "USUARIO")
    private String username;

    @Column(nullable = false, name = "CORREO", unique = true)
    private String emailId;

    @Column(nullable = false, name = "CONTRASEÑA")
    private String password;

    @Column(name = "TELEFONO")
    private String mobileNumber;

    @Column(nullable = false, name = "ROL")
    private String roles; //ROLE_ADMIN, ROLE_USER

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RefreshTokenEntity> refreshTokens;

}
