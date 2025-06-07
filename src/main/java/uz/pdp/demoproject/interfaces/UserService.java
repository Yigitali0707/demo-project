package uz.pdp.demoproject.interfaces;

import org.springframework.data.domain.Page;
import uz.pdp.demoproject.dto.*;

public interface UserService {
    TokenDto login(LoginDto loginDto);

    UserResponseDto register(UserRegisterDto userRegisterDto);

    Page<UserInfoDto> getAllUser(int page, int size);


    UserInfoDto getUserInfo();

    UserInfoDto updateUserInfo(UserInfoDto userInfoDto);

    String deleteUser();
}
