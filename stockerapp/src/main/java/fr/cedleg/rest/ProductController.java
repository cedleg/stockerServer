package fr.cedleg.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import fr.cedleg.model.Product;

@Path("/stock")
public class ProductController extends RestController {

    @GET()
    @Path("product/all")
    public Response getProducts() {	
    	List<Product> list = dsService.getAllProducts();
    	return spreadResponse(list);
    }
    
    @GET()
    @Path("product/{id}")
    public Response getProduct(@PathParam("id") Long id) {
    	Product p = (Product) dsService.find(Product.class, id);
    	if(p!=null) {
    		return Response.status(200).entity(p).build();
    	} else {
    		return Response.status(400).build();
    	}
    }
    
    @GET()
    @Path("productbycat/{name}")
    public Response getProducts(@PathParam("name") String name) {
    	List<Product> list = dsService.getProductsByCategory(name);
    	return spreadResponse(list);
    }
    
}
