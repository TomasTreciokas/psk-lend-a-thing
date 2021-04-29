package rest;

import entity.Lendee;
import repository.LendeeDAO;
import rest.model.request.LendeeRequest;
import rest.model.response.LendeeResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@ApplicationScoped
@Path("/lendee")
public class LendingController {

    @Inject
    private LendeeDAO lendeeDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response getById(@PathParam("id") @Min(1) int id) {
        Lendee lendee = lendeeDAO.findOne(id);

        if (Objects.isNull(lendee)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(LendeeResponse.from(lendee)).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") @Min(1) int lendeeId, @NotNull LendeeRequest request) {
        try {
            Lendee lendee = lendeeDAO.findOne(lendeeId);
            if (Objects.isNull(lendee)) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            lendee.setItems(request.getItems());
            lendee.setEmail(request.getEmail());

            lendeeDAO.update(lendee);
            return Response.ok(LendeeResponse.from(lendee)).build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(LendeeRequest request) {
        try {
            Lendee lendee = new Lendee(request.getId(), request.getEmail());
            lendeeDAO.persist(lendee);
            return Response.ok(LendeeResponse.from(lendee)).build();
        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
