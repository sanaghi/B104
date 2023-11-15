package az.lesson.spring.customerservice.service;

import az.lesson.spring.customerservice.dao.request.SigninRequest;
import az.lesson.spring.customerservice.dao.response.JwtAuthenticationResponse;
import az.lesson.spring.customerservice.entity.Customer;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(Customer request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
