package fr.cedleg.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.cedleg.model.Matter;

@Path("/stock")
public class MatterController extends RestController {

	/**
	 * Get all Matters from GET request
	 * @return Response (200) JSON or XML List<Matter>
	 * @return BadRequest (400)
	 */
    @GET
    @Path("matter/all")
    public Response getMatters(){
    	List<Matter> list = dsService.getAllMatters();
    	return spreadResponse(list);
    }
    
    /**
     * Get Matter by Id from GET request
     * @param id
     * @return Response (200) JSON or XML Category item
     * @return BadRequest (400)
     */
    @GET
    @Path("matter/{id}")
    public Response getMatter(@PathParam("id") Long id) {
    	Matter m = (Matter) dsService.find(Matter.class, id);
    	if(m!=null) {
    		return Response.status(200).entity(m).build();
    	} else {
    		return Response.status(400).build();
    	}
    }
}
