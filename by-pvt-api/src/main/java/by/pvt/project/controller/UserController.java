package by.pvt.project.controller;

import by.pvt.project.dto.UserRequest;
import by.pvt.project.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
public interface UserController {
    @GetMapping("/getAll")
    List<UserResponse> findAll();

    @PostMapping("/add")
    UserResponse add(@RequestBody @Valid UserRequest userRequest);

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @PostMapping("/update")
    List<UserResponse> update(@RequestBody UserRequest userRequest);

    @GetMapping("/{id}")
    UserResponse findById(@PathVariable("id") Long id);

    @PostMapping("/sendMail")
    String sendEmail(@RequestBody UserRequest userRequest);

    @GetMapping("/page")
    Page<UserResponse> getOrderResponses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size);

}
