package uz.pdp.demoproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.demoproject.entity.Role;
import uz.pdp.demoproject.entity.User;
import uz.pdp.demoproject.entity.enums.RoleName;
import uz.pdp.demoproject.repository.RoleRepository;
import uz.pdp.demoproject.repository.UserRepository;

import java.util.List;


@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run(String... args) throws Exception {
        if(ddl.equals("create")){
            Role role1=Role.builder()
                    .id(1L)
                    .roleName(RoleName.ROLE_USER)
                    .build();
            Role role2=Role.builder()
                    .id(2L)
                    .roleName(RoleName.ROLE_ADMIN)
                    .build();
            roleRepository.save(role1);
            roleRepository.save(role2);

            User user= User.builder()
                    .username("Admin")
                    .password(passwordEncoder.encode("123"))
                    .roles(List.of(role1,role2))
                    .build();
            userRepository.save(user);
        }

    }
}
