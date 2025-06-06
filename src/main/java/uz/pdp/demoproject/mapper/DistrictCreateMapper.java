package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.DistrictCreateDto;
import uz.pdp.demoproject.entity.District;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DistrictCreateMapper {
    @Mapping(source = "regionId", target = "region.id")
    District toEntity(DistrictCreateDto districtCreateDto);

    @Mapping(source = "region.id", target = "regionId")
    DistrictCreateDto toDto(District district);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "regionId", target = "region.id")
    District partialUpdate(DistrictCreateDto createDistrictDto, @MappingTarget District district);
}