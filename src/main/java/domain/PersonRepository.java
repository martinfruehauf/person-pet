package domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PersonRepository {
    @PersistenceContext(unitName = "default")
    private EntityManager em;

    private static  final Logger LOG = LoggerFactory.getLogger(PersonRepository.class);

    public List<Person> getPersons() {
        LOG.info("Get all persons");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> root = cq.from(Person.class);
        CriteriaQuery<Person> all = cq.select(root);
        TypedQuery<Person> allQuery = em.createQuery(all);
        return allQuery.getResultList();
    }

    public long addPerson(final Person person) {
        LOG.info("Add person");
        em.persist(person);
        return person.getId();
    }
}
