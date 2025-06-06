package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.demoproject.entity.User;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
public record UserRegisterDto(@NotBlank String username, @NotBlank String password, String firstName, String lastName,
                              Integer age) implements Serializable {
}