package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.dto.UserResponseDto;
import uz.pdp.demoproject.entity.Role;
import uz.pdp.demoproject.entity.User;
import uz.pdp.demoproject.entity.enums.RoleName;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)public interface UserResponseMapper {
    User toEntity(UserResponseDto userResponseDto);

    UserResponseDto toDto(User user);

    default RoleName map(Role role) {
        return role != null ? role.getRoleName() : null;
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)User partialUpdate(UserResponseDto userResponseDto, @MappingTarget User user);
}