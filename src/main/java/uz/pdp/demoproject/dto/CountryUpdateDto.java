package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotBlank;
import uz.pdp.demoproject.entity.enums.Continent;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.demoproject.entity.Country}
 */
public record CountryUpdateDto(@NotBlank String name, @NotBlank Continent continent) implements Serializable {
}