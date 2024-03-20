package com.qstack.codeflow.qstack.controllers;

import com.qstack.codeflow.qstack.dtos.AuthenticationRequest;
import com.qstack.codeflow.qstack.dtos.AuthenticationResponse;
import com.qstack.codeflow.qstack.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/authentication")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException exception){
            throw new BadCredentialsException("Incorrect Email or Password");
        }catch (DisabledException disabledException){
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User Is Not Created");
            return null;
        }
        final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        final  String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return new AuthenticationResponse(jwt);
    }
}
