package com.qstack.codeflow.qstack.dtos;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String password;

}
