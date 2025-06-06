package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.demoproject.entity.District}
 */
public record DistrictCreateDto(@NotBlank String name,@NotNull Long regionId) implements Serializable {
}