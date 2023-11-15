package az.lesson.spring.customerservice.service.impl;

import az.lesson.spring.customerservice.dao.request.SigninRequest;
import az.lesson.spring.customerservice.dao.response.JwtAuthenticationResponse;
import az.lesson.spring.customerservice.entity.Customer;
import az.lesson.spring.customerservice.enums.Role;
import az.lesson.spring.customerservice.repository.CustomerRepository;
import az.lesson.spring.customerservice.service.AuthenticationService;
import az.lesson.spring.customerservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(Customer request) {
        var user = Customer.builder().age(request.getAge()).person(request.getPerson())
                .email(request.getEmail()).password(request.getPassword())
                .role(Role.USER).build();
        customerRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
