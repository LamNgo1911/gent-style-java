package e_commerce.gent_style.domain.model;

import e_commerce.gent_style.domain.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @NotNull(message = "Name must not be null")
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role should not be null")
    private Role role;

    @Column(nullable = false)
    @NotNull(message = "Email must not be null")
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "password can not be null")
    @Pattern(regexp = "^(.{8,})$", message = "Password must be at least 8 characters long")
    private String password;
}
