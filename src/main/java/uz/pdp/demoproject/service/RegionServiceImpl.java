package uz.pdp.demoproject.service;



import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.demoproject.dto.*;
import uz.pdp.demoproject.entity.Country;
import uz.pdp.demoproject.entity.District;
import uz.pdp.demoproject.entity.Region;
import uz.pdp.demoproject.exception.DataIntegrityException;
import uz.pdp.demoproject.exception.ResourceNotFoundException;
import uz.pdp.demoproject.interfaces.RegionService;
import uz.pdp.demoproject.mapper.RegionCreateMapper;
import uz.pdp.demoproject.mapper.RegionResponseMapper;
import uz.pdp.demoproject.repository.DistrictRepository;
import uz.pdp.demoproject.repository.RegionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionResponseMapper regionResponseMapper;
    private final RegionCreateMapper createRegionMapper;
    private final RegionRepository regionRepository;
    private final CountryServiceImpl countryService;
    private final DistrictRepository districtRepository;

    @Override
    public Page<RegionResponseDto> getAllRegion(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Region> allRegions = regionRepository.findAll(pageable);
        return allRegions.map(regionResponseMapper::toDto);
    }


    @Override
    public RegionResponseDto getById(Long id) {
        Region region = getRegion(id);
        return regionResponseMapper.toDto(region);
    }

    @Override
    public RegionResponseDto createRegion(RegionCreateDto regionCreateDto) {
        Region region =createRegionMapper.toEntity(regionCreateDto);
        region.setCountry(countryService.getCountry(regionCreateDto.countryId()));
        Region savedRegion = regionRepository.save(region);
        return regionResponseMapper.toDto(savedRegion);
    }

    @Override
    public RegionResponseDto updateRegion(Long id, RegionUpdateDto regionUpdateDto) {
        Region region = getRegion(id);
        region.setName(regionUpdateDto.name());
        Country country = countryService.getCountry(regionUpdateDto.countryId());
        region.setCountry(country);
        regionRepository.save(region);
        return regionResponseMapper.toDto(region);
    }

    @Override
    @Transactional
    public String deleteRegion(Long id) {
        Region region = getRegion(id);
        boolean hasDistrict = districtRepository.existsByRegionId(id);
        if (hasDistrict) {
            throw new DataIntegrityException("Cannot delete country with id=" + id + " because it has associated districts.");
        }
        regionRepository.delete(region);
        return "Region deleted successfully";
    }

    public Region getRegion(Long id) {
        Optional<Region> region = regionRepository.findById(id);
        if (region.isPresent()) {
            return region.get();
        } else {
            throw new ResourceNotFoundException("Region with id=" + id + " not found!");
        }
    }
}
