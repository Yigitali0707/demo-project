package uz.pdp.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.demoproject.entity.Country;



public interface CountryRepository extends JpaRepository<Country, Long> {
}
