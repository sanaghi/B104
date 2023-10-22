package az.lesson.spring.customerservice.service;

import az.lesson.spring.customerservice.entity.Customer;
import az.lesson.spring.customerservice.repository.CustomerRepository;
import az.lesson.spring.customerservice.repository.PersonRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CustomerServiceImpl  implements CustomerService{
    CustomerRepository customerRepository;
    PersonService personService;

    public CustomerServiceImpl(CustomerRepository customerRepository, PersonService personService) {
        this.customerRepository = customerRepository;
        this.personService = personService;
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
//        return customerRepository.getCustomersByDebt(debt);
        return null;
    }

    @Override
    public List<Customer> getCustomersByDebtAndNameAndSurname(Double debt, String name, String surName) {
//        return customerRepository.getCustomerByDebtAndNameAndSurN
        return  null;
    }

    @Override
    public ResponseEntity<Customer> addCustomer(Customer customer) {
        try {
//            customer.setPerson(personService.createPerson(customer.getPerson()));
            Customer addedCstomer = customerRepository.save(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedCstomer);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(Customer customer) {
        try {
            Customer updatedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(updatedCustomer);
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Override
    public ResponseEntity<String> deleteCustomerById(Long id) {
        try {
            customerRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Customer with ID " + id + " deleted successfully");
        } catch (EmptyResultDataAccessException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with ID " + id + " not found");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete customer: " + e.getMessage());
        }
    }


}
