package uz.pdp.demoproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.demoproject.dto.DistrictCreateDto;
import uz.pdp.demoproject.dto.DistrictUpdateDto;
import uz.pdp.demoproject.interfaces.DistrictService;


@RestController
@RequestMapping("/api/district")
@RequiredArgsConstructor
public class DistrictController {
       private final DistrictService districtService;

    @GetMapping
    public HttpEntity<?> getAllDistrict(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(districtService.getAllDistrict(page,size));
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(districtService.getById(id));
    }

    @PostMapping
    public HttpEntity<?> saveCountry(DistrictCreateDto districtCreateDto){
        return ResponseEntity.ok(districtService.createDistrict(districtCreateDto));
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id, DistrictUpdateDto districtUpdateDto){
        return ResponseEntity.ok(districtService.updateDistrict(id,districtUpdateDto));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteDistrict(@PathVariable Long id){
        return ResponseEntity.ok(districtService.deleteDistrict(id));
    }
}
