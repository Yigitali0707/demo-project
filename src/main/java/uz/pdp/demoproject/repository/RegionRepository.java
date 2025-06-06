package uz.pdp.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.demoproject.entity.Region;



public interface RegionRepository extends JpaRepository<Region, Long> {
    boolean existsByCountryId(Long id);
}
