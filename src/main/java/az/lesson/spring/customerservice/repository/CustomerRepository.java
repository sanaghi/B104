package az.lesson.spring.customerservice.repository;

import az.lesson.spring.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {
    Optional<Customer> findByEmail(String email);

//    @Query( nativeQuery = true, value = "select c.name from customer c where id = :id ");
//    String getCustomerName(@Param("id") Long id);
//
//    @Query(
//            nativeQuery = true,
//            value
//                    = "select c.name from customer c where id = :id ")
//    String getCustomerNameById(@Param("id") Long id);
//
////    @Query(" FROM Customer c WHERE id = :id") //hql
////    List<Customer> findByFirstName(@Param("id") String id);
//
//    @Query("SELECT c.name FROM Customer c WHERE c.id = :id")
//    String findNameByIdJpql(@Param("id") Long id);
//
//    List<Customer> getCustomersByDebt(double debt);
//    List<Customer> getCustomerByDebtAndNameAndSurName(double debt,String name,String surName);



}
