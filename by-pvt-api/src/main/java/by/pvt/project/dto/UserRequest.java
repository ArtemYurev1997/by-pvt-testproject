package by.pvt.project.dto;

import by.pvt.project.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;


@Getter
@Setter
@ToString
public class UserRequest {
    @Transient
    private Long id;
    @NotBlank(message = "The field must contain a name")
    @Length(max = 20, message = "Too many characters for name")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters a-z and A-Z")
    private String name;
    @NotBlank(message = "The field must contain a surname")
    @Length(max = 40, message = "Too many characters for surname")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters a-z and A-Z")
    private String surname;
    @NotBlank(message = "The field must contain a patronymic")
    @Length(max = 40, message = "Too many characters for patronymic")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters a-z and A-Z")
    private String patronymic;
    @NotBlank(message = "The field must contain a email")
    @Length(max = 50, message = "Too many characters for email")
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
