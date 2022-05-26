package com.example.signuplogin.controller;


import com.example.signuplogin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public void creatUser(@RequestBody CreateUserDto dto) {
        userService.creatUser(dto);
    }

    @GetMapping("/{user-id}")
    public ReadUserDto readUser(@PathVariable("user-id") Integer id) {
        return userService.readUser(id);
    }

    @PutMapping("/{user-id}")
    public void updateUser(@RequestBody UpdateUserDto dto, @PathVariable("user-id") Integer id) {
        userService.updateUser(dto, id);
    }

    @DeleteMapping("/{user-id}")
    private void deleteUser(@PathVariable("user-id") Integer id) {
        userService.deleteUser(id);
    }
}
