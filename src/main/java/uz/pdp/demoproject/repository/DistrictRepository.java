package uz.pdp.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.demoproject.entity.District;



public interface DistrictRepository extends JpaRepository<District, Long> {
    boolean existsByRegionId(Long id);
}
