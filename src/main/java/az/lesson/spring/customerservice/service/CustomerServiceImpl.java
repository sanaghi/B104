package az.lesson.spring.customerservice.service;

import az.lesson.spring.customerservice.domain.Customer;
import az.lesson.spring.customerservice.repository.CustomerRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CustomerServiceImpl  implements CustomerService{
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        System.out.println("getAllCustomer");
//        customerRepository.getCustomerByDebt();
        return  customerRepository.findAll();
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        System.out.println("getCustomerById");
        if(customer.isPresent()){
           return  ResponseEntity.ok(customer.get());
        }else {
           return  ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<Customer> getCustomersByDebt(Double debt) {
        return customerRepository.getCustomersByDebt(debt);
    }

    @Override
    public List<Customer> getCustomersByDebtAndNameAndSurname(Double debt, String name, String surName) {
        return customerRepository.getCustomerByDebtAndNameAndSurName(debt,name,surName);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Customer added  =  customerRepository.save(customer);
        return  added;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer updatedCustomer = customerRepository.save(customer);
        System.out.println("updated");
        return  updatedCustomer;
    }

    @Override
    public void deleteCustomerById(Long id) {
        System.out.println("deleted");
        customerRepository.deleteById(id);
    }


}
