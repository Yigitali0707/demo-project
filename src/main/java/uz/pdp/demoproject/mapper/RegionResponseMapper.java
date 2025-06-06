package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.RegionResponseDto;
import uz.pdp.demoproject.entity.Region;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionResponseMapper {
    @Mapping(source = "countryName", target = "country.name")
    Region toEntity(RegionResponseDto regionResponseDto);

    @Mapping(source = "country.name", target = "countryName")
    RegionResponseDto toDto(Region region);

    @Mapping(source = "countryName", target = "country.name")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Region partialUpdate(RegionResponseDto regionResponseDto, @MappingTarget Region region);
}