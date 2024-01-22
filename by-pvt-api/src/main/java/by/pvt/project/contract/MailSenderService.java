package by.pvt.project.contract;

import by.pvt.project.dto.UserRequest;

public interface MailSenderService {
    void send(UserRequest userRequest);
}
