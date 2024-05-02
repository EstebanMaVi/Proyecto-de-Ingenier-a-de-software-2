package com.springsecurity.oauth2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserRegistrationDto (
        @NotEmpty(message = "El nombre de usuario no puede estar vacío.")
        String usuario,
        String telefono,
        @NotEmpty(message = "El correo no puede estar vacío.") //Neither null nor 0 size
        @Email(message = "El formato del correo es inválido.")
        String correo,
        @NotEmpty(message = "La contraseña no puede estar vacía.")
        String contraseña,
        @NotEmpty(message = "El rol del usuario no puede estar vacío.")
        String rol
){ }
