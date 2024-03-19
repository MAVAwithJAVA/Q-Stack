package com.qstack.codeflow.qstack.services.user;

import com.qstack.codeflow.qstack.dtos.SignUpRequest;
import com.qstack.codeflow.qstack.dtos.UserDto;
import com.qstack.codeflow.qstack.entities.User;
import com.qstack.codeflow.qstack.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDto createUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signUpRequest.getPassword()));
        User CreateUser=userRepository.save(user);
        UserDto createUserDto = new UserDto();
        createUserDto.setId(CreateUser.getId());
        return createUserDto;
    }

    @Override
    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
