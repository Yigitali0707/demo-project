package uz.pdp.demoproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.demoproject.dto.CountryCreateDto;
import uz.pdp.demoproject.dto.CountryResponseDto;
import uz.pdp.demoproject.dto.CountryUpdateDto;
import uz.pdp.demoproject.entity.Country;
import uz.pdp.demoproject.exception.DataIntegrityException;
import uz.pdp.demoproject.exception.ResourceNotFoundException;
import uz.pdp.demoproject.interfaces.CountryService;
import uz.pdp.demoproject.mapper.CountryCreateMapper;
import uz.pdp.demoproject.mapper.CountryResponseMapper;
import uz.pdp.demoproject.repository.CountryRepository;
import uz.pdp.demoproject.repository.RegionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryResponseMapper countryResponseMapper;
    private final CountryCreateMapper countryCreateMapper;
    private final RegionRepository regionRepository;


    @Override
    public CountryResponseDto getById(Long id) {
        Country country = getCountry(id);
        return countryResponseMapper.toDto(country);
    }

    @Override
    public Page<CountryResponseDto> getAllCountry(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Country> allCountrys = countryRepository.findAll(pageable);
        return allCountrys.map(countryResponseMapper::toDto);
    }

    @Override
    public CountryResponseDto createCountry(CountryCreateDto countryCreateDto) {
        Country country=countryCreateMapper.toEntity(countryCreateDto);
        Country savedCountry = countryRepository.save(country);
        return countryResponseMapper.toDto(savedCountry);
    }

    @Override
    public CountryResponseDto updateCountry(Long id, CountryUpdateDto updateCountryDto) {
        Country country = getCountry(id);
        country.setName(updateCountryDto.name());
        country.setContinent(updateCountryDto.continent());
        countryRepository.save(country);
        return countryResponseMapper.toDto(country);
    }



    @Override
    @Transactional
    public String deleteCountry(Long id) {
        Country country = getCountry(id);
        boolean hasRegions = regionRepository.existsByCountryId(id);
        if (hasRegions) {
            throw new DataIntegrityException("Cannot delete country with id=" + id + " because it has associated regions.");
        }
        countryRepository.delete(country);
        return "Country deleted successfully";
    }


    public Country getCountry(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        if (country.isPresent()) {
            return country.get();
        } else {
            throw new ResourceNotFoundException("Country with id=" + id + " not found!");
        }
    }


}
