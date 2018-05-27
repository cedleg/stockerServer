package fr.cedleg.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.cedleg.model.Category;

@Path("/stock")
public class CategoryController extends RestController {

    @GET
    @Path("category/all")
    public Response getCategories(){
    	List<Category> list = dsService.getAllCategories();
    	return spreadResponse(list);
    }
    
    @GET
    @Path("category/{id}")
    public Response getCategories(@PathParam("id") Long id) {
    	Category c = (Category) dsService.find(Category.class, id);
    	return spreadResponse(c);
    }
    
}
