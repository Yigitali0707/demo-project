package uz.pdp.demoproject.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link uz.pdp.demoproject.entity.District}
 */
public record DistrictResponseDto(Long id, String name, String regionName,
                                  LocalDateTime createdAt) implements Serializable {
}