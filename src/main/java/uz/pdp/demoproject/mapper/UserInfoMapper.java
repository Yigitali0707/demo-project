package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.UserInfoDto;
import uz.pdp.demoproject.entity.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserInfoMapper {
    User toEntity(UserInfoDto userInfoDto);

    UserInfoDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserInfoDto userInfoDto, @MappingTarget User user);
}