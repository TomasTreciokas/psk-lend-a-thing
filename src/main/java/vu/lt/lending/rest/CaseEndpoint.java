package vu.lt.lending.rest;

import vu.lt.lending.rest.request.CaseInstanceRequest;
import vu.lt.lending.rest.response.CaseInstanceResponse;
import vu.lt.lending.service.CaseService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Valid
@Path("/case")
public class CaseEndpoint {

    @Inject
    private CaseService service;

    @GET
    @Path("/{id}")
    public CaseInstanceResponse getCaseInstance(@PathParam("case_id") String caseId) {
        return this.service.retrieveCaseInstance(caseId);
    }

    @POST
    public CaseInstanceResponse createCase(CaseInstanceRequest request) {
        return this.service.createCase(request);
    }
}
