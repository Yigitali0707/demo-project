package uz.pdp.demoproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.demoproject.dto.DistrictCreateDto;
import uz.pdp.demoproject.dto.DistrictResponseDto;
import uz.pdp.demoproject.dto.DistrictUpdateDto;
import uz.pdp.demoproject.entity.District;
import uz.pdp.demoproject.entity.Region;

import uz.pdp.demoproject.exception.ResourceNotFoundException;
import uz.pdp.demoproject.interfaces.DistrictService;
import uz.pdp.demoproject.mapper.DistrictCreateMapper;
import uz.pdp.demoproject.mapper.DistrictResponseMapper;
import uz.pdp.demoproject.repository.DistrictRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final RegionServiceImpl regionService;
    private final DistrictResponseMapper districtResponseMapper;
    private final DistrictCreateMapper districtCreateMapper;


    @Override
    public Page<DistrictResponseDto> getAllDistrict(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<District> allRegions = districtRepository.findAll(pageable);
        return allRegions.map(districtResponseMapper::toDto);
    }

    @Override
    public DistrictResponseDto getById(Long id) {
        District district = getDistrict(id);
        return districtResponseMapper.toDto(district);
    }

    @Override
    public DistrictResponseDto createDistrict(DistrictCreateDto districtCreateDto) {
        District district = districtCreateMapper.toEntity(districtCreateDto);
        Region region = regionService.getRegion(districtCreateDto.regionId());
        district.setRegion(region);
        District savedDistrict = districtRepository.save(district);
        return districtResponseMapper.toDto(savedDistrict);
    }

    @Override
    public DistrictResponseDto updateDistrict(Long id, DistrictUpdateDto updateDistrictDto) {
        District district = getDistrict(id);
        district.setName(updateDistrictDto.name());
        district.setRegion(regionService.getRegion(updateDistrictDto.regionId()));
        districtRepository.save(district);
        return districtResponseMapper.toDto(district);
    }

    @Override
    @Transactional
    public String deleteDistrict(Long id) {
        District district = getDistrict(id);
        districtRepository.delete(district);
        return "District deleted successfully";
    }

    public District getDistrict(Long id) {
        Optional<District> district = districtRepository.findById(id);
        if (district.isPresent()) {
            return district.get();
        } else {
            throw new ResourceNotFoundException("District with id=" + id + " not found!");
        }
    }
}
