package com.example.signuplogin.service;

import com.example.signuplogin.controller.CreateUserDto;
import com.example.signuplogin.controller.ReadUserDto;
import com.example.signuplogin.controller.UpdateUserDto;
import com.example.signuplogin.entity.User;
import com.example.signuplogin.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;

    public void creatUser(CreateUserDto dto) {
        userRepository.save(User.builder()
                .name(dto.getName())
                .number(dto.getNumber())
                .badScore(dto.getBadScore())
                .build());
    }
    public ReadUserDto readUser(Integer id) {
        User user = userRepository.findById(id).get();

        return ReadUserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .number(user.getNumber())
                .badScore(user.getBadScore())
                .build();
    }

    @Transactional
    public void updateUser(UpdateUserDto dto, Integer id) {
        User user = userRepository.findById(id).get();

        user.setName(dto.getName());
        user.setNumber(dto.getNumber());
        user.setBadScore(dto.getBadScore());
    }

    @Transactional
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
