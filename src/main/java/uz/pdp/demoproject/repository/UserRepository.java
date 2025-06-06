package uz.pdp.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.demoproject.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
