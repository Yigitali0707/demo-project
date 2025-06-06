package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.CountryResponseDto;
import uz.pdp.demoproject.entity.Country;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryResponseMapper {
    Country toEntity(CountryResponseDto countryResponseDto);

    CountryResponseDto toDto(Country country);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country partialUpdate(CountryResponseDto countryResponseDto, @MappingTarget Country country);
}