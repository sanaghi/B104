package az.lesson.spring.customerservice.service;

import az.lesson.spring.customerservice.entity.Person;
import az.lesson.spring.customerservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person createPerson(Person person) {
        System.out.println("---------"+personRepository.existsByFinCode(person.getFinCode()));
        if(!personRepository.existsByFinCode(person.getFinCode())) {
            return personRepository.save(person);
        } else {

            throw  new RuntimeException("already exist");
        }
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

}
