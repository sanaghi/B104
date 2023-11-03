package az.lesson.spring.customerservice.service;

import az.lesson.spring.customerservice.dto.CustomerDTO;
import az.lesson.spring.customerservice.entity.Customer;
import az.lesson.spring.customerservice.entity.Person;
import az.lesson.spring.customerservice.enums.ErrorMessages;
import az.lesson.spring.customerservice.exception.CustomerNotFoundException;
import az.lesson.spring.customerservice.repository.CustomerRepository;
import az.lesson.spring.customerservice.util.CustomerMapper;
import eye2web.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CustomerServiceImpl  implements CustomerService{
    CustomerRepository customerRepository;
    PersonService personService;

    ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, PersonService personService,ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.personService = personService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Customer> getAllCustomer() {
        System.out.println("getAllCustomer");
//        customerRepository.getCustomerByDebt();
          return customerRepository.findAll();

    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        System.out.println("getCustomerById");
        if(customer.isPresent()){
//            CustomerDTO customerDTO = CustomerMapper.convertCustomertoDto(customer.get());
            CustomerDTO customerDTO = modelMapper.map(customer.get(),CustomerDTO.class);
           return  ResponseEntity.ok(customerDTO);
        }else {
           throw new CustomerNotFoundException(ErrorMessages.CUSTOMER_NOT_FOUND.getMessage());
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





    @Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = {},noRollbackFor = {NullPointerException.class})
    public  Person addPerson(Person p){
        return  personService.createPerson(p);
    }

    @Override
    @Transactional
    public ResponseEntity<Customer> addCustomer(Customer customer) {

        System.out.println("customer in service "+customer);

        Person  person = customer.getPerson();
        customer.setPerson(null);




        try {
//            customer.setPerson(personService.createPerson(customer.getPerson()));
            Customer addedCstomer = customerRepository.save(customer);
//
            addPerson(person);
//


            person.setFinCode("23323232");
            customer.setPerson(person);
             addedCstomer = customerRepository.save(customer);


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
