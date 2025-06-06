package uz.pdp.demoproject.mapper;

import org.mapstruct.*;
import uz.pdp.demoproject.entity.User;
import uz.pdp.demoproject.dto.UserRegisterDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserRegisterMapper {
    User toEntity(UserRegisterDto userRegisterDto);

    UserRegisterDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserRegisterDto userRegisterDto, @MappingTarget User user);
}