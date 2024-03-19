package com.qstack.codeflow.qstack.services.user;

import com.qstack.codeflow.qstack.dtos.SignUpRequest;
import com.qstack.codeflow.qstack.dtos.UserDto;

public interface UserService {

    UserDto createUser(SignUpRequest signUpRequest);

    boolean hasUserWithEmail(String email);
}
