package az.lesson.spring.customerservice.controller;

import az.lesson.spring.customerservice.domain.Customer;
import az.lesson.spring.customerservice.service.CustomerService;
import az.lesson.spring.customerservice.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
  public class CustomerController {
    CustomerService customerService;

    public    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Customer> getCustomerById(@PathVariable  Long id){
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
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody  Customer customer){
        return  ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customer));
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody  Customer customer){
        return  ResponseEntity.ok(customerService.updateCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public  void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
}
