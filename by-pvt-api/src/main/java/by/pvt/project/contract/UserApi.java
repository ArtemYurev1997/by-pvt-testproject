package by.pvt.project.contract;

import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserApi {
    UserResponse register(UserRequest userRequest);

    void delete(Long id);

    List<UserResponse> getAllUsers();

    UserResponse findClientById(Long id);

    List<UserResponse> update(UserRequest userRequest);

    Page<UserResponse> getOrdersPages(int page, int size);

}
