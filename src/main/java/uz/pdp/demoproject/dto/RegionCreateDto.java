package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.demoproject.entity.Region}
 */
public record RegionCreateDto(@NotBlank String name,@NotNull Long countryId) implements Serializable {
}