package com.example.signuplogin.controller;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadUserDto {

    private Integer id;

    private String name;

    private Integer number;

    private Integer badScore;
}
