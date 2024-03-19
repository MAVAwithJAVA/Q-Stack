package com.qstack.codeflow.qstack.services.user;

import com.qstack.codeflow.qstack.dtos.SignUpDto;
import com.qstack.codeflow.qstack.dtos.UserDto;
import com.qstack.codeflow.qstack.entities.User;
import com.qstack.codeflow.qstack.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(SignUpDto signupDto) {
        User user = new User();
        user.setUsername(signupDto.getUsername());
        user.setEmail(signupDto.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDto.getPassword()));
        User CreateUser=userRepository.save(user);
        UserDto createUserDto = new UserDto();
        createUserDto.setId(CreateUser.getId());
        return createUserDto;
    }
}
