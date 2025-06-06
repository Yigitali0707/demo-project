package uz.pdp.demoproject.dto;

import uz.pdp.demoproject.entity.Region;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Region}
 */
public record RegionResponseDto(Long id, String name, String countryName, LocalDateTime createdAt) implements Serializable {
}