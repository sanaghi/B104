package az.lesson.spring.customerservice.util;

import az.lesson.spring.customerservice.dto.CustomerDTO;
import az.lesson.spring.customerservice.entity.Customer;

public class CustomerMapper {
    public static  CustomerDTO convertCustomertoDto(Customer customer){

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setAge(customer.getAge());
        customerDTO.setDebt(customer.getDebt());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setId(customer.getId());
        return  customerDTO;
    }
}
