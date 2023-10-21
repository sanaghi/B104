package az.lesson.spring.customerservice.repository;

import az.lesson.spring.customerservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
