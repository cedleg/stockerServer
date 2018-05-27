package fr.cedleg.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.cedleg.model.Unit;

@Path("/stock")
public class UnitController extends RestController{
	
    @GET
    @Path("unit/all")
    public Response getUnits(){
    	List<Unit> list = dsService.getAllUnits();
    	return spreadResponse(list);
    }
    
    @GET
    @Path("unit/{id}")
    public Response getUnit(@PathParam("id") Long id) {
    	Unit u = (Unit) dsService.find(Unit.class, id);
    	return spreadResponse(u);
    }
}
