package uz.pdp.demoproject.dto;

import uz.pdp.demoproject.entity.enums.Continent;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link uz.pdp.demoproject.entity.Country}
 */
public record CountryResponseDto(Long id, String name, Continent continent, LocalDateTime createdAt) implements Serializable {
}