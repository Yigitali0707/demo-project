package uz.pdp.demoproject.interfaces;


import org.springframework.data.domain.Page;

import uz.pdp.demoproject.dto.RegionCreateDto;
import uz.pdp.demoproject.dto.RegionResponseDto;
import uz.pdp.demoproject.dto.RegionUpdateDto;


public interface RegionService {
    Page<RegionResponseDto> getAllRegion(int page, int size);

    RegionResponseDto getById(Long id);

    RegionResponseDto createRegion(RegionCreateDto createRegionDto);

    RegionResponseDto updateRegion(Long id, RegionUpdateDto updateRegionDto);

    String deleteRegion(Long id);
}

