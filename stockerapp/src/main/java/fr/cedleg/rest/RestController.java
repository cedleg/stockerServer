package fr.cedleg.rest;

import javax.ejb.EJB;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.cedleg.service.DatasourceService;

@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
public abstract class RestController {

	@EJB
	protected DatasourceService dsService;

	public DatasourceService getDsService() {
		return dsService;
	}

	protected Response spreadResponse(Object obj) {
    	if(obj!=null) {
    		return Response.status(200).entity(obj).build();
    	} else {
    		return Response.status(400).build();
    	}
    }
}
