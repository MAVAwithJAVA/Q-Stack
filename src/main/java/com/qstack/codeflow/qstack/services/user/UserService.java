package com.qstack.codeflow.qstack.services.user;

import com.qstack.codeflow.qstack.dtos.SignUpDto;
import com.qstack.codeflow.qstack.dtos.UserDto;
import com.qstack.codeflow.qstack.entities.User;

public interface UserService {

    UserDto createUser(SignUpDto signupDto);
}
