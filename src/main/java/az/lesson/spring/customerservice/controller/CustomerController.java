package az.lesson.spring.customerservice.controller;

import az.lesson.spring.customerservice.dto.CustomerDTO;
import az.lesson.spring.customerservice.entity.Customer;
import az.lesson.spring.customerservice.service.CustomerService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableMethodSecurity
@RequestMapping("/api/customer")
  public class CustomerController {
    CustomerService customerService;

    public    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public  ResponseEntity<CustomerDTO> getCustomerById(@PathVariable  Long id){
        return  customerService.getCustomerById(id);
    }

    @GetMapping("/debt/{debt}")
    public  ResponseEntity<List<Customer>> getCustomersByDebt(@PathVariable  Double debt){
        return  ResponseEntity.ok(customerService.getCustomersByDebt(debt));
    }
    @GetMapping("/debt/{debt}/{name}/{surname}")
    public  ResponseEntity<List<Customer>> getCustomersByDebt(@PathVariable  Double debt,@PathVariable String name,@PathVariable String surname){
        return  ResponseEntity.ok(customerService.getCustomersByDebtAndNameAndSurname(debt,name,surname));
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer(){
//        int a = 9/0;
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer( @Valid @RequestBody  Customer customer){
        System.out.println(customer);
        return customerService.addCustomer(customer);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody  Customer customer){
        return  customerService.updateCustomer(customer);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        return  customerService.deleteCustomerById(id);
    }
}
