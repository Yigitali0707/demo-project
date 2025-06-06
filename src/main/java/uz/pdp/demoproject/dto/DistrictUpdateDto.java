package uz.pdp.demoproject.dto;

import java.io.Serializable;

/**
 * DTO for {@link uz.pdp.demoproject.entity.District}
 */
public record DistrictUpdateDto(String name, Long regionId) implements Serializable {
}