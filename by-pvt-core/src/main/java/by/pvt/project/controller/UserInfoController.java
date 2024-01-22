package by.pvt.project.controller;

import by.pvt.project.contract.MailSenderService;
import by.pvt.project.contract.UserApi;
import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserInfoController implements UserController {
    private final UserApi userApi;
    private final MailSenderService mailSenderService;

    @Override
    public List<UserResponse> findAll() {
        return userApi.getAllUsers();
    }

    @Override
    public UserResponse add(UserRequest userRequest) {
        return userApi.register(userRequest);
    }

    @Override
    public void delete(Long id) {
        userApi.delete(id);
    }

    @Override
    public List<UserResponse> update(UserRequest userRequest) {
        return userApi.update(userRequest);
    }

    @Override
    public UserResponse findById(Long id) {
        return userApi.findClientById(id);
    }

    @Override
    public String sendEmail(UserRequest userRequest) {
        mailSenderService.send(userRequest);
        return "Message was send successfully!";
    }

    @Override
    public Page<UserResponse> getOrderResponses(int page, int size) {
        return userApi.getOrdersPages(page, size);
    }
}
