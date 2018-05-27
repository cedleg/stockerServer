package fr.cedleg.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.cedleg.model.BatchProducts;

@Path("/stock")
public class BatchProductController extends RestController {
	
	/**
	 * Get all Batch of Products from GET request
	 * @return Response (200) JSON or XML List<BatchProduct>
	 * @return BadRequest (400)
	 */
    @GET()
    @Path("batch/all")
    public Response getBathProducts() {	
    	List<BatchProducts> list = dsService.getAllBathProducts();
    	return spreadResponse(list);
    }
    
    /**
     * Get BatchProduct by Id from GET request
     * @param id
     * @return Response (200) JSON or XML BatchProduct item
     * @return BadRequest (400)
     */
    @GET()
    @Path("batch/{id}")
    public Response getBatch(@PathParam("id") Long id) {
    	BatchProducts b = (BatchProducts) dsService.find(BatchProducts.class, id);
    	return spreadResponse(b);
    }
    
}
