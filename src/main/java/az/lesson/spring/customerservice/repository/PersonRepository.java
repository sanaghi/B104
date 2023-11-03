package az.lesson.spring.customerservice.repository;

import az.lesson.spring.customerservice.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByFinCode(String finCode);
}
