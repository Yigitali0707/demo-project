package uz.pdp.demoproject.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.demoproject.dto.LoginDto;
import uz.pdp.demoproject.dto.UserInfoDto;
import uz.pdp.demoproject.dto.UserResponseDto;
import uz.pdp.demoproject.entity.User;
import uz.pdp.demoproject.dto.UserRegisterDto;
import uz.pdp.demoproject.entity.enums.RoleName;
import uz.pdp.demoproject.exception.AuthenticationException;
import uz.pdp.demoproject.exception.UserAlreadyExistsException;
import uz.pdp.demoproject.interfaces.UserService;

import uz.pdp.demoproject.mapper.UserInfoMapper;
import uz.pdp.demoproject.mapper.UserRegisterMapper;
import uz.pdp.demoproject.mapper.UserResponseMapper;
import uz.pdp.demoproject.repository.RoleRepository;
import uz.pdp.demoproject.repository.UserRepository;
import uz.pdp.demoproject.security.JwtUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserResponseMapper userResponseMapper;
    private final UserRegisterMapper userRegisterMapper;
    private final UserInfoMapper userInfoMapper;


    public String login(LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password())
            );
            User user = (User) authentication.getPrincipal();
            return jwtUtil.generateToken(user.getUsername(), user.getRoles());
        } catch (org.springframework.security.core.AuthenticationException e) {
            throw new AuthenticationException("Invalid username or password");
        }
    }


    public UserResponseDto register(UserRegisterDto userRegisterDto) {
        if (userRepository.findByUsername(userRegisterDto.username()) != null) {
            throw new UserAlreadyExistsException("User already exists");
        }
        User user= userRegisterMapper.toEntity(userRegisterDto);
        user.setPassword(passwordEncoder.encode(userRegisterDto.password()));
        user.setRoles(List.of(roleRepository.findByRoleName(RoleName.ROLE_USER)));
        User save = userRepository.save(user);
        return userResponseMapper.toDto(save);
    }

    @Override
    public Page<UserInfoDto> getAllUser(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> allUsers = userRepository.findAll(pageable);
        return allUsers.map(userInfoMapper::toDto);
    }

    @Override
    public UserInfoDto getUserInfo() {
          User user=getCurrentUser();
        return userInfoMapper.toDto(user);
    }

    @Override
    public UserInfoDto updateUserInfo(UserInfoDto userInfoDto) {
        User user = getCurrentUser();
        if (!user.getUsername().equals(userInfoDto.username())&&userRepository.findByUsername(userInfoDto.username()) != null) {
            throw new UserAlreadyExistsException("Username already exists");
        }
        user.setUsername(userInfoDto.username());
        user.setFirstName(userInfoDto.firstName());
        user.setLastName(userInfoDto.lastName());
        user.setAge(userInfoDto.age());
        userRepository.save(user);
        return userInfoMapper.toDto(user);
    }

    @Override
    @Transactional
    public String deleteUser() {
        User user = getCurrentUser();
        userRepository.delete(user);
        SecurityContextHolder.clearContext();
        return "User successfully deleted.";
    }


    public User getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }


}
