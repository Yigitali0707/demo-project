package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.RegionCreateDto;
import uz.pdp.demoproject.entity.Region;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionCreateMapper {
    @Mapping(source = "countryId", target = "country.id")
    Region toEntity(RegionCreateDto regionCreateDto);

    @Mapping(source = "country.id", target = "countryId")
    RegionCreateDto toDto(Region region);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "countryId", target = "country.id")
    Region partialUpdate(RegionCreateDto regionCreateDto, @MappingTarget Region region);
}