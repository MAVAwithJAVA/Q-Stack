package com.qstack.codeflow.qstack.controllers;

import com.qstack.codeflow.qstack.dtos.SignUpRequest;
import com.qstack.codeflow.qstack.dtos.UserDto;
import com.qstack.codeflow.qstack.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> signupUser(@RequestBody SignUpRequest signUpRequest) throws Exception {

        if(userService.hasUserWithEmail(signUpRequest.getEmail()))
            return new ResponseEntity<>("user already exists with this" + signUpRequest.getEmail(),HttpStatus.NOT_ACCEPTABLE);

        UserDto createdUser=userService.createUser(signUpRequest);
        if(createdUser==null)
            return new ResponseEntity<>("user not created, come again later", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

}
