package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotBlank;
import uz.pdp.demoproject.entity.Region;

import java.io.Serializable;

/**
 * DTO for {@link Region}
 */
public record RegionUpdateDto(@NotBlank String name, Long countryId) implements Serializable {
}