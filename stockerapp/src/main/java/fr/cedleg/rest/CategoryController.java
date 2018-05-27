package fr.cedleg.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.cedleg.model.Category;

@Path("/stock")
public class CategoryController extends RestController {

	/**
	 * Get all Categories from GET request
	 * @return Response (200) JSON or XML List<Category>
	 * @return BadRequest (400)
	 */
    @GET
    @Path("category/all")
    public Response getCategories(){
    	List<Category> list = dsService.getAllCategories();
    	return spreadResponse(list);
    }
    
    /**
     * Get Category by Id from GET request
     * @param id
     * @return Response (200) JSON or XML Category item
     * @return BadRequest (400)
     */
    @GET
    @Path("category/{id}")
    public Response getCategories(@PathParam("id") Long id) {
    	Category c = (Category) dsService.find(Category.class, id);
    	return spreadResponse(c);
    }
    
}
