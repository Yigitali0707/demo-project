package uz.pdp.demoproject.interfaces;

import org.springframework.data.domain.Page;
import uz.pdp.demoproject.dto.LoginDto;
import uz.pdp.demoproject.dto.UserInfoDto;
import uz.pdp.demoproject.dto.UserResponseDto;
import uz.pdp.demoproject.dto.UserRegisterDto;

public interface UserService {
    String login(LoginDto loginDto);

    UserResponseDto register(UserRegisterDto userRegisterDto);

    Page<UserInfoDto> getAllUser(int page, int size);


    UserInfoDto getUserInfo();

    UserInfoDto updateUserInfo(UserInfoDto userInfoDto);

    String deleteUser();
}
