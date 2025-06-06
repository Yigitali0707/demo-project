package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.CountryCreateDto;
import uz.pdp.demoproject.entity.Country;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountryCreateMapper {
    Country toEntity(CountryCreateDto countryCreateDto);

    CountryCreateDto toDto(Country country);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Country partialUpdate(CountryCreateDto countryCreateDto, @MappingTarget Country country);
}