package by.pvt.project.service;

import by.pvt.project.contract.UserApi;
import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import by.pvt.project.entity.UserInfo;
import by.pvt.project.exception.AccountException;
import by.pvt.project.mapper.UserMappers;
import by.pvt.project.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserInfoService implements UserApi {
    private final UserInfoRepository userRepository;
    private final UserMappers userMappers;

    @Override
    public UserResponse register(UserRequest userRequest) {
        UserInfo user = userMappers.toEntity(userRequest);;
        userRepository.save(user);
        return userMappers.toResponse(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMappers::toResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse findClientById(Long id) {
        Optional<UserResponse> user = Optional.of(userMappers.toResponse(userRepository.findById(id).orElseThrow(() -> new AccountException("Don't exist user!"))));
        return user.get();
    }

    @Override
    public List<UserResponse> update(UserRequest userRequest) {
        Optional<UserInfo> user = Optional.ofNullable(userRepository.findByNameAndSurname(userRequest.getName(), userRequest.getSurname()).orElseThrow(() -> new AccountException("Don't exist user!")));
        if (user.isPresent()) {
            userRepository.save(userMappers.toEntity(userRequest));
        }
        return getAllUsers();
    }

    public Page<UserResponse> getOrdersPages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return userRepository.findAll(pageable).map(userMappers::toResponse);
    }
}
