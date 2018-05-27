package fr.cedleg.rest;

import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.cedleg.service.DatasourceService;


public abstract class RestController {

	@EJB
	protected DatasourceService dsService;

	/**
	 * Response XML or JSON propagation from object state
	 * @param obj
	 * @return Response (200) or (400)
	 */
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	protected Response spreadResponse(Object obj) {
    	if(obj!=null) {
    		return Response.status(200).entity(obj).build();
    	} else {
    		return Response.status(400).build();
    	}
    }
}
