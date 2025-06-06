package uz.pdp.demoproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import uz.pdp.demoproject.entity.Country;
import uz.pdp.demoproject.entity.enums.Continent;

import java.io.Serializable;

/**
 * DTO for {@link Country}
 */
public record CountryCreateDto(@NotBlank String name, @NotBlank Continent continent) implements Serializable {
}