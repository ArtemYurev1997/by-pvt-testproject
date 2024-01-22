package by.pvt.project.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String role;
}
