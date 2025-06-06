package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.DistrictResponseDto;
import uz.pdp.demoproject.entity.District;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DistrictResponseMapper {
    @Mapping(source = "regionName", target = "region.name")
    District toEntity(DistrictResponseDto districtResponseDto);

    @Mapping(source = "region.name", target = "regionName")
    DistrictResponseDto toDto(District district);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "regionName", target = "region.name")
    District partialUpdate(DistrictResponseDto districtResponseDto, @MappingTarget District district);
}