package fr.cedleg.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.cedleg.model.Product;

@Path("/stock")
public class ProductController extends RestController {

	/**
	 * Get all Products from GET request
	 * @return Response (200) JSON or XML List<Product>
	 * @return BadRequest (400)
	 */
    @GET()
    @Path("product/all")
    public Response getProducts() {	
    	List<Product> list = dsService.getAllProducts();
    	return spreadResponse(list);
    }
    
    /**
     * Get product item by Id 
     * @param id
     * @return Response (200) JSON or XML Product item
     * @return BadRequest (400)
     */
    @GET()
    @Path("product/{id}")
    public Response getProduct(@PathParam("id") Long id) {
    	Product p = (Product) dsService.find(Product.class, id);
    	return spreadResponse(p);
    }
    
    /**
     * Get products items by Category Name 
     * @param name of Category
     * @return Response (200) JSON or XML List<Product>
     * @return BadRequest (400)
     */
    @GET()
    @Path("productbycat/{name}")
    public Response getProducts(@PathParam("name") String name) {
    	List<Product> list = dsService.getProductsByCategory(name);
    	return spreadResponse(list);
    }
    
    /**
     * Create a new Product from POST request
     * @param toSave JSON Product item
     * @return Response (201) JSON or XML Product item
     * @return Conflict (409)
     */
	@POST
	@Path("product/new")
	@Consumes(value = {MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	public Response saveProduct(Product toSave) {	
		if((Product)dsService.find(Product.class, toSave.getId())!=null) {
			return Response.status(409).build();
		}
		dsService.persit(toSave);
		return Response.ok().status(201).build();
	}
	
	/**
	 * Update Product from PUT request 
	 * @param toUpdate JSON Product item
	 * @return Response (202) JSON or XML Product item
	 * @return Not Found (404)
	 */
	@PUT
	@Path("product/change")
	@Consumes(value = {MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	public Response updateProduct(Product toUpdate) {	
		if(dsService.find(Product.class, toUpdate.getId())==null) {
			return Response.status(404).build();
		}
		dsService.merge(toUpdate);
		Product entity = (Product) dsService.find(Product.class, toUpdate.getId());
		return Response.status(202).entity(entity).build();
	}
	
	/**
	 *  Remove Product from DELETE request
	 * @param id
	 * @return Response (202) JSON or XML Product item state before delete
	 * @return BadRequest (400)
	 */
	@DELETE
	@Path("product/{id}")
	@Produces({MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
	public Response deleteProduct(@PathParam("id") Long id) {
		Product p = (Product) dsService.find(Product.class, id);
		if(p==null) {
			return Response.status(400).build();
		}
		dsService.remove(p);
		return Response.accepted().build();
	}
    
}
