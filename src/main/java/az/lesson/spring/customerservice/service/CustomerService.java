package az.lesson.spring.customerservice.service;

import az.lesson.spring.customerservice.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    List<Customer>  getAllCustomer();
    ResponseEntity<Customer> getCustomerById(Long id);

    ResponseEntity<Customer> addCustomer(Customer customer);
    ResponseEntity<Customer> updateCustomer(Customer customer);
    ResponseEntity<String> deleteCustomerById(Long id);

    List<Customer> getCustomersByDebt(Double debt);
    List<Customer> getCustomersByDebtAndNameAndSurname(Double debt,String name,String surName);
}
