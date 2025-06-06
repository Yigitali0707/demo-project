package uz.pdp.demoproject.interfaces;


import org.springframework.data.domain.Page;
import uz.pdp.demoproject.dto.CountryCreateDto;
import uz.pdp.demoproject.dto.CountryResponseDto;

import uz.pdp.demoproject.dto.CountryUpdateDto;
import uz.pdp.demoproject.entity.Country;

public interface CountryService {
    CountryResponseDto getById(Long id);
    Page<CountryResponseDto> getAllCountry(int page, int size);
    CountryResponseDto createCountry(CountryCreateDto countryCreateDto);
    CountryResponseDto updateCountry(Long id, CountryUpdateDto countryUpdateDto);

    String deleteCountry(Long id);
}

