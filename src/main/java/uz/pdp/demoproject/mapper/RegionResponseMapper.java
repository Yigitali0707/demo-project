package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.RegionResponseDto;
import uz.pdp.demoproject.entity.Region;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionResponseMapper {
    Region toEntity(RegionResponseDto regionResponseDto);

    RegionResponseDto toDto(Region region);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Region partialUpdate(RegionResponseDto regionResponseDto, @MappingTarget Region region);
}