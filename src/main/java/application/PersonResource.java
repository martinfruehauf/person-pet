package application;

import domain.Person;
import domain.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static final Logger LOG = LoggerFactory.getLogger(PersonResource.class);

    @Inject
    private PersonService personService;

    public PersonResource() {
        LOG.info("Person Resource created");
    }

    public PersonResource(final PersonService personService) {
        this.personService = personService;
    }

    List<Person> personList;

    @GET
    public Response PersonResource() {
        LOG.info("Person Resource created");
        List<FullPersonDTO> listFullPersonDTO = new ArrayList<>();
        for (Person person: personService.listPerson()) {
            listFullPersonDTO.add(new FullPersonDTO(person));
        }
        return Response.ok().entity(listFullPersonDTO).build();
    }



    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public Response addPerson(final BasePersonDTO basePersonDTO) {
        LOG.info("Create new person");
        long personId = personService.addPerson(basePersonDTO);
        String uri = "/api/todos/" + personId;
        return Response.status(Response.Status.CREATED).entity(uri).build();

    }
}
