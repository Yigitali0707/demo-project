package uz.pdp.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.demoproject.entity.Role;
import uz.pdp.demoproject.entity.enums.RoleName;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(RoleName roleName);
}
