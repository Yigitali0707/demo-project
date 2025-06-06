package uz.pdp.demoproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.demoproject.dto.RegionCreateDto;
import uz.pdp.demoproject.dto.RegionUpdateDto;
import uz.pdp.demoproject.interfaces.RegionService;


@RestController
@RequestMapping("/api/region")
@RequiredArgsConstructor
public class RegionController {
       private final RegionService regionService;

    @GetMapping
    public HttpEntity<?> getAllRegion(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(regionService.getAllRegion(page,size));
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(regionService.getById(id));
    }

    @PostMapping
    public HttpEntity<?> saveCountry(RegionCreateDto regionCreateDto){
        return ResponseEntity.ok(regionService.createRegion(regionCreateDto));
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id, RegionUpdateDto regionUpdateDto){
        return ResponseEntity.ok(regionService.updateRegion(id,regionUpdateDto));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteRegion(@PathVariable Long id){
        return ResponseEntity.ok(regionService.deleteRegion(id));
    }
}
