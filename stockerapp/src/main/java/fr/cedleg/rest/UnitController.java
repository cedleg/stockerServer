package fr.cedleg.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.cedleg.model.Unit;

@Path("/stock")
public class UnitController extends RestController{
	
	/**
	 * Get all Units from GET request
	 * @return Response (200) JSON or XML List<Unit>
	 * @return BadRequest (400)
	 */
    @GET
    @Path("unit/all")
    public Response getUnits(){
    	List<Unit> list = dsService.getAllUnits();
    	return spreadResponse(list);
    }
    
    /**
     * Get Unit from GET request
     * @param id
     * @return Response (200) JSON or XML Unit item
     * @return BadRequest (400)
     */
    @GET
    @Path("unit/{id}")
    public Response getUnit(@PathParam("id") Long id) {
    	Unit u = (Unit) dsService.find(Unit.class, id);
    	return spreadResponse(u);
    }
}
