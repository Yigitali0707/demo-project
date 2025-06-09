package uz.pdp.demoproject.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.demoproject.dto.RegionCreateDto;
import uz.pdp.demoproject.dto.RegionUpdateDto;
import uz.pdp.demoproject.interfaces.RegionService;


@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class RegionController {
       private final RegionService regionService;

    @GetMapping("/user/region")
    public HttpEntity<?> getAllRegion(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(regionService.getAllRegion(page,size));
    }

    @GetMapping("/user/region/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(regionService.getById(id));
    }

    @PostMapping("/admin/region")
    public HttpEntity<?> saveCountry(RegionCreateDto regionCreateDto){
        return ResponseEntity.ok(regionService.createRegion(regionCreateDto));
    }

    @PutMapping("/admin/region/{id}")
    public HttpEntity<?> update(@PathVariable Long id, RegionUpdateDto regionUpdateDto){
        return ResponseEntity.ok(regionService.updateRegion(id,regionUpdateDto));
    }

    @DeleteMapping("/admin/region/{id}")
    public HttpEntity<?> deleteRegion(@PathVariable Long id){
        return ResponseEntity.ok(regionService.deleteRegion(id));
    }
}
