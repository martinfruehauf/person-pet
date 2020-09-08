package domain;

import application.BasePersonDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;

public class PersonService {
    @Inject
    private PersonRepository personRepository;

    private List<Person> personList;

    private static final Logger LOG = LoggerFactory.getLogger(PersonService.class);

    public PersonService() {

    }

    public List<Person> listPerson() {
        LOG.info("Get all persons");
        return personRepository.getPersons();
    }

    public long addPerson(final BasePersonDTO basePersonDTO) {
        LOG.info("Add person");
        Person person = new Person(basePersonDTO);
        return personRepository.addPerson(person);
    }
}
