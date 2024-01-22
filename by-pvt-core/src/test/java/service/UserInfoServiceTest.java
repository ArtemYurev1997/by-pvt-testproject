package service;

import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import by.pvt.project.entity.UserInfo;
import by.pvt.project.enums.UserRole;
import by.pvt.project.mapper.UserMappers;
import by.pvt.project.repository.UserInfoRepository;
import by.pvt.project.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserInfoServiceTest {
    @Mock
    private UserInfoRepository userRepository;

    @Mock
    private UserMappers userMappers;

    @InjectMocks
    private UserInfoService userInfoService;

    @Test
    public void register_positiveTest() {
        UserInfo userInfo = client();
        UserRequest userRequest = clientRequest();
        UserResponse userResponse = new UserResponse();
        when(userMappers.toEntity(userRequest)).thenReturn(client());
        when(userRepository.save(any())).thenReturn(userInfo);
        when(userMappers.toResponse(any())).thenReturn(userResponse);
        UserResponse actualResult = userInfoService.register(userRequest);
        assertEquals(userResponse, actualResult);
    }

    private UserInfo client() {
        UserInfo client = new UserInfo();
        client.setId(1L);
        client.setName("Valery");
        client.setSurname("Valereev");
        client.setPatronymic("Ivanovich");
        client.setEmail("valery1344@mail.ru");
        client.setRole(UserRole.CUSTOMER_USER);
        return client;
    }

    private UserRequest clientRequest() {
        UserRequest client = new UserRequest();
        client.setId(2L);
        client.setName("Valery");
        client.setSurname("Valereev");
        client.setPatronymic("Ivanovich");
        client.setEmail("valery1344@mail.ru");
        client.setRole(UserRole.CUSTOMER_USER);
        return client;
    }
}
