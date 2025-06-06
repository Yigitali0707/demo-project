package uz.pdp.demoproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uz.pdp.demoproject.dto.CountryCreateDto;
import uz.pdp.demoproject.dto.CountryUpdateDto;
import uz.pdp.demoproject.interfaces.CountryService;


@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;


    @GetMapping
    public HttpEntity<?> getAllCountry(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(countryService.getAllCountry(page,size));
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(countryService.getById(id));
    }

    @PostMapping
    public HttpEntity<?> saveCountry(CountryCreateDto countyCreateDto){
          return ResponseEntity.ok(countryService.createCountry(countyCreateDto));
    }

    @PutMapping("/{id}")
    public HttpEntity<?> update(@PathVariable Long id, CountryUpdateDto countryUpdateDto){
            return ResponseEntity.ok(countryService.updateCountry(id,countryUpdateDto));
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteCountry(@PathVariable Long id){
        return ResponseEntity.ok(countryService.deleteCountry(id));
    }

    
}
