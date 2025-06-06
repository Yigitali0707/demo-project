package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotNull;
import uz.pdp.demoproject.entity.enums.RoleName;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link uz.pdp.demoproject.entity.User}
 */
public record UserResponseDto(Long id,String username, String firstName, String lastName, Integer age,
                              List<RoleName> roles) implements Serializable {
}