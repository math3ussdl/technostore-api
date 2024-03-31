package me.math3ussdl.technostoreapi.user.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    
    private UUID id;

    @NotEmpty(message = "Name is required!")
    @Size(min = 4, max = 80, message = "Name must be between 4 and 80 characters!")
    private String name;

    @NotEmpty(message = "Email is required!")
    @Email(message = "Invalid email!")
    private String email;

    private boolean active;
    
    private OffsetDateTime created;
    private OffsetDateTime updated;
}
