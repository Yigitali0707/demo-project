package uz.pdp.demoproject.interfaces;

import org.springframework.data.domain.Page;
import uz.pdp.demoproject.dto.DistrictCreateDto;
import uz.pdp.demoproject.dto.DistrictResponseDto;
import uz.pdp.demoproject.dto.DistrictUpdateDto;
import uz.pdp.demoproject.dto.RegionResponseDto;

public interface DistrictService {
    Page<DistrictResponseDto> getAllDistrict(int page, int size);


    DistrictResponseDto getById(Long id);

    DistrictResponseDto createDistrict(DistrictCreateDto districtCreateDto);

    DistrictResponseDto updateDistrict(Long id, DistrictUpdateDto districtUpdateDto);

    String deleteDistrict(Long id);
}
