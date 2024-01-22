package by.pvt.project.mapper;

import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import by.pvt.project.entity.UserInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMappers {
    UserInfo toEntity(UserRequest userRequest);
    UserResponse toResponse(UserInfo user);
}
