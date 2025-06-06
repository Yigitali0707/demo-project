package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.demoproject.entity.User}
 */
public record UserInfoDto(Long id, @NotNull String username, String firstName, String lastName,
                          Integer age) implements Serializable {
}