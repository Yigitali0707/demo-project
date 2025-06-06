package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.RegionCreateDto;
import uz.pdp.demoproject.entity.Region;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionCreateMapper {
    @Mapping(target = "country", ignore = true)
    Region toEntity(RegionCreateDto dto);

    RegionCreateDto toDto(Region region);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)Region partialUpdate(RegionCreateDto regionCreateDto, @MappingTarget Region region);
}