package uz.pdp.demoproject.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uz.pdp.demoproject.dto.CountryCreateDto;
import uz.pdp.demoproject.dto.CountryUpdateDto;
import uz.pdp.demoproject.interfaces.CountryService;


@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;


    @GetMapping("/user/country")
    public HttpEntity<?> getAllCountry(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(countryService.getAllCountry(page,size));
    }

    @GetMapping("/user/country/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(countryService.getById(id));
    }

    @PostMapping("/admin/country")
    public HttpEntity<?> saveCountry(CountryCreateDto countyCreateDto){
          return ResponseEntity.ok(countryService.createCountry(countyCreateDto));
    }

    @PutMapping("/admin/country/{id}")
    public HttpEntity<?> update(@PathVariable Long id, CountryUpdateDto countryUpdateDto){
            return ResponseEntity.ok(countryService.updateCountry(id,countryUpdateDto));
    }

    @DeleteMapping("/admin/country/{id}")
    public HttpEntity<?> deleteCountry(@PathVariable Long id){
        return ResponseEntity.ok(countryService.deleteCountry(id));
    }

    
}
