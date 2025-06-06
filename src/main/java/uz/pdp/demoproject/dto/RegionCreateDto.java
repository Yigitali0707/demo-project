package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.demoproject.entity.Region}
 */
public record RegionCreateDto(@NotBlank String name, Long countryId) implements Serializable {
}