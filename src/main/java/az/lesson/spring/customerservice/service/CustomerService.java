package az.lesson.spring.customerservice.service;

import az.lesson.spring.customerservice.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer>  getAllCustomer();
    ResponseEntity< Customer> getCustomerById(Long id);

    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomerById(Long id);

    List<Customer> getCustomersByDebt(Double debt);
    List<Customer> getCustomersByDebtAndNameAndSurname(Double debt,String name,String surName);
}
